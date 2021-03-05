package com.db.library.Controllers;

import com.db.library.Admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RegisterAdminController {
    @GetMapping("/register_admin")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "register_form_admin";
    }
}
