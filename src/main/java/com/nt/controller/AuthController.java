package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@GetMapping("/")
	public String home() {
		return "Welcome to online banking portal";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Login Successfull via google OAuth2!";
	}
	
	
}
