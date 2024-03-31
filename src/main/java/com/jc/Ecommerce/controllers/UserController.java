package com.jc.Ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.Ecommerce.dto.UserDTO;
import com.jc.Ecommerce.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping(value = "/{id}")
	public UserDTO finfByID(@PathVariable Long id) {
		UserDTO dto = userservice.findById(id);
			return dto;
		
		
		
	}

}
