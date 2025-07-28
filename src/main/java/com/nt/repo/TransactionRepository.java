package com.nt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Account;
import com.nt.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

	List<Transaction> findBySourceAccount(String sourceAccount) ;
	
//	List<Transaction>  findBySource1Account(String sourceAccount);
	
	List<Transaction> findByTargetAccount(String targetAccount);
}
