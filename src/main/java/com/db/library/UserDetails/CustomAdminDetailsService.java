package com.db.library.UserDetails;

import com.db.library.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByUsername(username);
		if (admin == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomAdminDetails(admin);
	}

}
