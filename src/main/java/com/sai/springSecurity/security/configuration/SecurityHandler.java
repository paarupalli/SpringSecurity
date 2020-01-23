package com.sai.springSecurity.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityHandler extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailsService usrdetService;
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder
	 * authManagBldr) throws Exception{
	 * 
	 * authManagBldr.inMemoryAuthentication().withUser("Paarupalli")
	 * .password("testPwd") .roles("USER") .and() .withUser("ADMIN")
	 * .password("root") .roles("USER");
	 * 
	 * 
	 * }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usrdetService);//.passwordEncoder(getPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
		.antMatchers("/Admin").hasRole("ADMIN")
		.antMatchers("/home").permitAll()
		.antMatchers("/hello/{name}").hasAnyRole("USER","ADMIN")
		.and().formLogin();
		
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}

}
