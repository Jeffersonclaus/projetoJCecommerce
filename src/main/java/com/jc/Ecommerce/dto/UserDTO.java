package com.jc.Ecommerce.dto;

import java.time.LocalDate;

import com.jc.Ecommerce.entity.User;

public class UserDTO {
	
	
	
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthDate;
	private String password;
	
	
	UserDTO(){
		
		
		
	}
	

	public UserDTO(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		
	}

	public UserDTO(User user ) {
		
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		birthDate = user.getBirthDate();
		
	}




	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
	
	


}
