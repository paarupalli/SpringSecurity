/**
 * 
 */
package com.sai.springSecurity.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.springSecurity.model.Users;

/**
 * @author parupalli
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Users findByUserId(String userId) {
		
		List<Users> user= sessionFactory.getCurrentSession()
				.createQuery("from Users where userId = :userId")
				.setParameter("userId", userId)
				.list();
		if(user.size() > 0) {
			System.out.println(user.get(0).getUserId()+"role"+user.get(0).getUserAuthorities().size());
			return user.get(0);
		}else {
		return null;
		}
	}

}
