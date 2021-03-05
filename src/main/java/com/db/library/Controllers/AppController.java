package com.db.library.Controllers;

import java.util.List;

import com.db.library.Admin;
import com.db.library.User;
import com.db.library.UserDetails.AdminRepository;
import com.db.library.UserDetails.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/library")
	public String library(Model model) {
		model.addAttribute("user", new User());
		
		return "library";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		return "register_success";
	}

	@GetMapping("/admin_register")
	public String showAdminRegistrationForm(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "signup_form_admin";
	}
	
	@PostMapping("/process_admin_register")
	public String processRegister(Admin admin) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(encodedPassword);
		adminRepo.save(admin);
		
		return "register_success";
	}
	
	@GetMapping("/admin")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		List<Admin> listAdmins = adminRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("listAdmins", listAdmins);
		
		return "admin";
	}
}
