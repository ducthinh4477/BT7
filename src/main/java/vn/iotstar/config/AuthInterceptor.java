package vn.iotstar.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        // kiểm tra session
        if (session != null && session.getAttribute("currentUser") != null) {
            return true;
        }

        // nếu chưa login → chuyển về login
        response.sendRedirect("/login");
        return false;
    }
}
