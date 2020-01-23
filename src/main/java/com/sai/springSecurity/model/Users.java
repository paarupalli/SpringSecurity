/**
 * 
 */
package com.sai.springSecurity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author parupalli
 *
 */
@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean isEnabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
	private Set<UserAuthorites> userAuthorities = new HashSet<UserAuthorites>();
	
	public Users() {
		
	}
	
	public Users(String userId, String password, boolean isEnabled, Set<UserAuthorites> userAuthorities) {
		super();
		this.userId = userId;
		this.password = password;
		this.isEnabled = isEnabled;
		this.userAuthorities = userAuthorities;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * @return the userAuthorities
	 */
	public Set<UserAuthorites> getUserAuthorities() {
		return userAuthorities;
	}
	/**
	 * @param userAuthorities the userAuthorities to set
	 */
	public void setUserAuthorities(Set<UserAuthorites> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	
	

}
