package com.db.library.Controllers;

import java.util.List;

import com.db.library.Entities.Admin;
import com.db.library.Entities.Book;
import com.db.library.Entities.Borrows;
import com.db.library.Entities.User;
import com.db.library.Repositories.AdminRepository;
import com.db.library.Repositories.BookRepository;
import com.db.library.Repositories.BorrowsRepository;
import com.db.library.Repositories.UserRepository;
import com.db.library.Services.BookService;
import com.db.library.UserDetails.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private BorrowsRepository borrowsRepo;

	@Autowired
    private BookService bookService;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/library")
    public String library(Model model, @Param("keyword") String keyword) {
        List<Book> listBooks = bookService.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        return "library";
    }	

	@RequestMapping(value = "/borrow", method = RequestMethod.GET)
    public String library(Authentication authentication, @Param("book") Book book) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
		Borrows borrows = new Borrows();
		borrows.setBorrower(user);
		borrows.setBook(book);
		borrowsRepo.save(borrows);
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
		userRepo.saveAndFlush(user);
		
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
		adminRepo.saveAndFlush(admin);
		
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
