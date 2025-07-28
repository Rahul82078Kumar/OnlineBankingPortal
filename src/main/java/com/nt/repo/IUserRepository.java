package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface IUserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
	
	
}
