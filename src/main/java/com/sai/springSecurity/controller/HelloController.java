/**
 * 
 */
package com.sai.springSecurity.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author parupalli
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping(value="/hello/{name}", method=RequestMethod.GET)
	@ResponseBody public String welcome(@PathVariable String name) {
		
		System.out.println("Hello "+name);
		return "Hello "+name;
		
	}

	@RequestMapping(value="/home", method=RequestMethod.GET)
	@ResponseBody public String login() {
		
		System.out.println("Hello Please Login");
		return "Hello Please Login";
		
	}
	
	@RequestMapping(value="/Admin", method=RequestMethod.GET)
	@ResponseBody public String admin() {
		
		System.out.println("Hello you are Admin");
		return "Hello You are Admin";
		
	}
}
