package com.jc.Ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jc.Ecommerce.dto.UserDTO;
import com.jc.Ecommerce.entity.User;
import com.jc.Ecommerce.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> result = repository.findById(id);
		User user = result.get();
		UserDTO userDTO = new UserDTO (user);
		return userDTO;
		
	}
	
	
	

}
