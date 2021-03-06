package com.db.library.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.db.library.Entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 5329910606691729173L;
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("USER"));
        return list;
    }

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String address() {
		return user.getAddress();
	}

	public String phone() {
		return user.getPhone();
	}

	public String cardNr() {
		return user.getCardNr();
	}

}
