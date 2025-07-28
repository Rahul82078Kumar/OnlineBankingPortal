package com.nt.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDTO {

	
	@NotBlank(message="Email is required")
	private String email;
	@NotBlank(message = "Passsword is required")
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
