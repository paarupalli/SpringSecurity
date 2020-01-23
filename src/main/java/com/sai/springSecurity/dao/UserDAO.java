/**
 * 
 */
package com.sai.springSecurity.dao;

import com.sai.springSecurity.model.Users;

/**
 * @author parupalli
 *
 */
public interface UserDAO {

	Users findByUserId(String userId);
}
