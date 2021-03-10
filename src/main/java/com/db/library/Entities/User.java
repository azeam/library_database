package com.db.library.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(name = "username", nullable = false, length = 255, unique = true)
	private String username;

    @Column(name = "address", nullable = true, length = 255)
	private String address;

    @Column(name = "cardNr", nullable = false, length = 255)
	private String cardNr;

    @Column(name = "phone", nullable = true, length = 255)
    private String phone;

	@OneToMany(mappedBy="borrower", cascade = CascadeType.ALL)
    private List<Borrows> userBorrows;

	// not part of db, only used for display
	@Transient
	private String borrowedBooksString;

	public List<Borrows> getUserBorrows() {
		return this.userBorrows;
	}

	public void setUserBorrows(List<Borrows> userBorrows) {
		this.userBorrows = userBorrows;
	}

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNr() {
        return this.cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

	@Transient
	public void setBorrowedBooksString(String borrowedBooksString) {
		this.borrowedBooksString = borrowedBooksString;
	}

	@Transient
	public String getBorrowedBooksString() {
		return this.borrowedBooksString;
	}
	
}
