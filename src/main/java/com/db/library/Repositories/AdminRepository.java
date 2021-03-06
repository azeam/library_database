package com.db.library.Repositories;

import com.db.library.Entities.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("SELECT u FROM Admin u WHERE u.username = ?1")
	public Admin findByUsername(String username);
	
}
