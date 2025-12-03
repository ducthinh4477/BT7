package vn.iotstar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null
            && user.getPassword().equals(password)
            && Boolean.TRUE.equals(user.getActive())) {
            return user;
        }
        return null;
    }

}
