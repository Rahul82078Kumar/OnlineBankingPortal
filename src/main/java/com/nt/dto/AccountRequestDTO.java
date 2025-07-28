package com.nt.dto;

public class AccountRequestDTO {

	private String accountType;
	private Double initialBalance;
	private Long userId;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public AccountRequestDTO(String accountType, Double initialBalance, Long userId) {
		super();
		this.accountType = accountType;
		this.initialBalance = initialBalance;
		this.userId = userId;
	}
	
	
	
	
}
