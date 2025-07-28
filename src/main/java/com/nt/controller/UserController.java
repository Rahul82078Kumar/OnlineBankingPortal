package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.LoginRequestDTO;
import com.nt.dto.UserRequestDTO;
import com.nt.dto.UserResponseDTO;
import com.nt.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO requestDTO){
		
		UserResponseDTO responseDTO=userService.registerUser(requestDTO);
		
		return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO requestDTO){
		UserResponseDTO responseDTO=userService.loginUser(requestDTO.getEmail(), requestDTO.getPassword());
	return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	
	}
	
	
	@GetMapping("info")
	public Map<String,Object> userInfo(@AuthenticationPrincipal OAuth2User user){
		return user.getAttributes();
	}
	
	
	
}
