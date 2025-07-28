package com.nt.service;

import java.util.Optional;

import com.nt.dto.UserRequestDTO;
import com.nt.dto.UserResponseDTO;
import com.nt.entity.User;

public interface IUserService {

		Optional<User> findByEmail(String email);
		
		UserResponseDTO registerUser(UserRequestDTO requestDTO);
		
		UserResponseDTO loginUser(String email,String password);
	
}
