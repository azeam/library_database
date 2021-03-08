package com.db.library.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(name = "username", nullable = false, length = 255, unique = true)
	private String username;

	@Column(name = "salary", nullable = true, length = 255)
	private String salary;

	@Column(name = "address", nullable = true, length = 255)
	private String address;

	@Column(name = "vacationDays", nullable = true, length = 255)
	private String vacationDays;

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVacationDays() {
		return this.vacationDays;
	}

	public void setVacationDays(String vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}