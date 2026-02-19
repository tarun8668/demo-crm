package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignup() {
        return "signup";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login-process")
    public String loginProcess(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "redirect:/dashboard";
        }
        return "redirect:/login?error";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}