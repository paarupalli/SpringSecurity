/**
 * 
 */
package com.sai.springSecurity.security.configuration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author parupalli
 *
 */
public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	
	public MyUserDetails() {
		
			}
	
	
	public MyUserDetails(String userName) {
		this.userName = userName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "password";
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
