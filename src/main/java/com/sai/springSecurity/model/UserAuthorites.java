/**
 * 
 */
package com.sai.springSecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author parupalli
 *
 */
@Entity
@Table(name="user_authorites")
public class UserAuthorites {
	
	@Id
	@Column(name="userRoleId")
	private Integer userRoleId;
	
	@Column(name="authority")
	private String role;
	
	@ManyToOne()
	@JoinColumn(name="userId")
	private Users user;
	
	
	
	
	
	public UserAuthorites() {
		
	}
	public UserAuthorites(String role, Users user) {
		super();
		this.role = role;
		this.user = user;
	}
	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}
	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}
	
	

}
