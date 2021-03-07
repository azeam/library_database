package com.db.library.Repositories;

import java.util.List;

import com.db.library.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u")
	public List<User> findAllUsers();

	@Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
}
