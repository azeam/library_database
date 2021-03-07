package com.db.library.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.db.library.Entities.Book;
import com.db.library.Entities.Borrows;
import com.db.library.Entities.User;
import com.db.library.Repositories.BookRepository;
import com.db.library.Repositories.UserRepository;
import com.db.library.UserDetails.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
