package com.nt.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.UserRequestDTO;
import com.nt.dto.UserResponseDTO;
import com.nt.entity.User;
import com.nt.repo.IUserRepository;

@Service
public class UserServiceImpl  implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public UserResponseDTO registerUser(UserRequestDTO requestDTO) {
		if(userRepo.findByEmail(requestDTO.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registred");
		}
		
		User user = User.builder()
				.name(requestDTO.getName())
				.email(requestDTO.getEmail())
		        .password(requestDTO.getPassword())
		        .createdAt(LocalDateTime.now())
		        .build();
		
		User saveUser = userRepo.save(user);
		System.out.println("Created from save user"+saveUser.getCreatedAt());
		
		UserResponseDTO responseDTO = new UserResponseDTO();
		responseDTO.setId(saveUser.getId());
		responseDTO.setName(saveUser.getName());
		responseDTO.setEmail(saveUser.getEmail());
		responseDTO.setCreatedAt(saveUser.getCreatedAt());
		
		return responseDTO;
	
	
	}

	@Override
	public UserResponseDTO loginUser(String email, String password) {
		User user=userRepo.findByEmail(email)
				.orElseThrow(()->new RuntimeException("Invalid email or password"));
		
		if(!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid email or  password");
		}
		
		return new UserResponseDTO(
				user.getId(),
				user.getEmail(),
				user.getName(),
				user.getCreatedAt());
	}
}
