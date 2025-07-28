package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private LocalDateTime createdAt;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Account account;
	
	public User() {
		
	}
	
	public User(Long id, String name, String email, String password, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
	
private User(UserBuilder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.email = builder.email;
    this.password = builder.password;
    this.createdAt = builder.createdAt;
}

 // ✅ Static inner Builder class
public static class UserBuilder {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User build() {
        return new User(this);
    }
    
}

public static UserBuilder builder() {
    return new UserBuilder();
}

// ✅ Getters
public Long getId() { return id; }
public String getName() { return name; }
public String getEmail() { return email; }
public String getPassword() { return password; }
public LocalDateTime getCreatedAt() { return createdAt; }




	
}

