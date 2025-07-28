package com.nt.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

	private String  transactionType ;
	private String fromAccount;
	private String toAccount;
	private double amount;
	private LocalDateTime timestamp;
	public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDTO(String transactionType, String fromAccount, String toAccount, double amount,
			LocalDateTime timestamp) {
		super();
		this.transactionType = transactionType;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
