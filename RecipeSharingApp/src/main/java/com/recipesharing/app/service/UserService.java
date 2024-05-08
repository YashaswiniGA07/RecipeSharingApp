package com.recipesharing.app.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.recipesharing.app.dto.UserRegistrationDTO;
import com.recipesharing.app.entity.UserEntity;




public interface UserService extends UserDetailsService{

	UserEntity save(UserRegistrationDTO userRegisteredDTO);
	
}
