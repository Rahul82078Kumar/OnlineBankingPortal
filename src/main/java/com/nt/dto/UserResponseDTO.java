package com.nt.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponseDTO {

	private Long id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	
	
	 public UserResponseDTO(Long id, String name, String email, LocalDateTime createdAt) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.createdAt = createdAt;
	    }
	
	 
	 public UserResponseDTO() {
		 
	 }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
