package com.db.library.Controllers;

import com.db.library.Entities.User;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RegisterController {
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }
}
