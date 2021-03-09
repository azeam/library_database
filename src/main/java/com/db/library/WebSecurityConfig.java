package com.db.library;

import com.db.library.Services.CustomAdminDetailsService;
import com.db.library.Services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(userAuthProvider());
		auth.authenticationProvider(adminAuthProvider());
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public UserDetailsService adminDetailsService() {
		return new CustomAdminDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// set bcrypt encoder for password
	private DaoAuthenticationProvider userAuthProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	private DaoAuthenticationProvider adminAuthProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(adminDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin").hasAuthority("ADMIN") // only admins have access to admin page
			.antMatchers("/library").authenticated() // logged in users have access to library
			.antMatchers(HttpMethod.POST, "/borrow").authenticated()
			.antMatchers(HttpMethod.POST, "/editAdmin").hasAuthority("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.usernameParameter("username")
				.defaultSuccessUrl("/redirect", true) // check current user's permissions and redirect from there, true bool fixes redirect issue at admin page (param = alwaysUse)
				.permitAll()
			.and()
			.logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
	}
	
}
