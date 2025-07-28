package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(unique = true,nullable = false)
	private String accountNumber;
	private String accountType;
	private Double balance;
	private LocalDateTime createdAt;
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName="id")
	private User user;
	
	
	
	public Account(Long accountId, String accountNumber, String accountType, Double balance, LocalDateTime createdAt,
			User user) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.createdAt = createdAt;
		this.user = user;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Account(AccountBuilder builder) {
        this.accountId = builder.accountId;
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.createdAt = builder.createdAt;
        this.user = builder.user;
    }
	
	public static class AccountBuilder {
        private Long accountId;
        private String accountNumber;
        private String accountType;
        private Double balance;
        private LocalDateTime createdAt;
        private User user;

        public AccountBuilder accountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountBuilder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public AccountBuilder balance(Double balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    // ✅ Static method to start building
    public static AccountBuilder builder() {
        return new AccountBuilder();
    }
	
	
	
	
	
	
	
	
	
}
