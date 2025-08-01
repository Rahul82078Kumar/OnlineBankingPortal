package com.nt.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private LocalDateTime timestamp;
	private int status;
	private String message;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(LocalDateTime timestamp, int status, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
