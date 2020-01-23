/**
 * 
 */
package com.sai.springSecurity.security.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sai.springSecurity.dao.UserDAO;
import com.sai.springSecurity.model.UserAuthorites;
import com.sai.springSecurity.model.Users;

/**
 * @author parupalli
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userDao.findByUserId(username);
		
		List<GrantedAuthority> userRoles = buildUserAuthority(user.getUserAuthorities());
		
		return buildUserForAuthentication(user,userRoles);
		//return new MyUserDetails(username);
	}

	
	private List<GrantedAuthority> buildUserAuthority(Set<UserAuthorites> userRoles){
		
		Set<GrantedAuthority> roleSet = new HashSet<GrantedAuthority>();
		
		for(UserAuthorites userauthorites: userRoles) {
			
			roleSet.add(new SimpleGrantedAuthority(userauthorites.getRole()));
		}
		
		List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>(roleSet);
		
		return roleList;
	}
	
	private User buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
		
		return new User(user.getUserId(),user.getPassword(),user.isEnabled(),true,true,true,authorities);
	}
}
