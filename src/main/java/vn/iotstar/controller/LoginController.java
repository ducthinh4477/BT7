package vn.iotstar.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.entity.User;
import vn.iotstar.service.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {

        User user = userService.login(username, password);

        if (user == null) {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }

        // lưu session người dùng
        session.setAttribute("currentUser", user);

        // điều hướng theo ROLE
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin/home";
        } else {
            return "redirect:/";
        }
    }

    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
