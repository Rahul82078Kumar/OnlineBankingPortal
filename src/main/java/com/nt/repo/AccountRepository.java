package com.nt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Account;
import com.nt.entity.Transaction;

public interface AccountRepository extends JpaRepository<Account,Long> {

	boolean existsByUserId(Long userId);
	
	Optional<Account> findByAccountNumber(String accountNumber);
	
	
	
}
