package com.nt.dto;

public class FundTransferResponseDTO {

	
	private String message;
	private Double remainingBalance;
	
	
	public FundTransferResponseDTO(String message, Double remainingBalance) {
		super();
		this.message = message;
		this.remainingBalance = remainingBalance;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Double getRemainingBalance() {
		return remainingBalance;
	}


	public void setRemainingBalance(Double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	
	
}
