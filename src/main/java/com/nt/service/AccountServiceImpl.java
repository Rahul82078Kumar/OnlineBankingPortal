package com.nt.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.AccountRequestDTO;
import com.nt.dto.AccountResponseDTO;
import com.nt.dto.FundTransferRequestDTO;
import com.nt.dto.FundTransferResponseDTO;
import com.nt.dto.TransactionDTO;
import com.nt.entity.Account;
import com.nt.entity.Transaction;
import com.nt.entity.User;
import com.nt.repo.AccountRepository;
import com.nt.repo.IUserRepository;
import com.nt.repo.TransactionRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	

	@Override
	public AccountResponseDTO createAccount(AccountRequestDTO request) {
		
		if(accountRepo.existsByUserId(request.getUserId())) {
			throw new RuntimeException("User already has an account");
		}
		
			User user = userRepo.findById(request.getUserId()).orElseThrow(()->new RuntimeException("User not found"));
				
			Account account = Account.builder()
					.accountNumber(generatedAccountNumber())
					.accountType(request.getAccountType())
					.balance(request.getInitialBalance())
					.user(user)
					.build();
			
			accountRepo.save(account);
			
			return new AccountResponseDTO(
					account.getAccountNumber(),
					account.getAccountType(),
					account.getBalance(),
					"Account created successfully");
	
		}
	
	private String generatedAccountNumber() {
		return "PNB"+System.currentTimeMillis();
	}

	@Override
	public FundTransferResponseDTO transferFund(FundTransferRequestDTO request) {
		
		Account source=accountRepo.findByAccountNumber(request.getSourceAccountNumber())
		.orElseThrow(()->new RuntimeException("Source account number not found"));
		
		Account target = accountRepo.findByAccountNumber(request.getTargetAccountNumber())
				.orElseThrow(()->new RuntimeException("Target account number not found"));
		
		if(source.getBalance() < request.getAmount()) {
			throw new RuntimeException("Insufficent Balance");
			
		}
		//deduct from source account
		source.setBalance(source.getBalance()-request.getAmount());
		
		//Add to target account
		target.setBalance(target.getBalance()+request.getAmount());
		
		
		//save updated account
		accountRepo.save(source);
		accountRepo.save(target);
		
		
		//Save Transaction Record
		Transaction txn = new Transaction(
				source.getAccountNumber(),
				target.getAccountNumber(),
				request.getAmount(),
				LocalDateTime.now()
				);
				
		
		transactionRepo.save(txn);
		
		return new FundTransferResponseDTO("Transfer successful",source.getBalance());
	}

	@Override
	public double checkBalance(String accountNumber) {
		Account account = accountRepo.findByAccountNumber(accountNumber)
				.orElseThrow(()->new RuntimeException("Account number not found"));
		
		return account.getBalance();
				
	}

	@Override
	public List<TransactionDTO> getTransactionHistory(String accountNumber) {
		
		List<Transaction> debit =transactionRepo.findBySourceAccount(accountNumber);
		List<Transaction> credit = transactionRepo.findByTargetAccount(accountNumber);
		
		List<TransactionDTO> allTransaction = new ArrayList<>();
		
		for(Transaction txn : debit) {
			TransactionDTO  dto= new TransactionDTO();
			dto.setTransactionType("DEBIT");
			dto.setFromAccount(txn.getSourceAccount());
			dto.setToAccount(txn.getTargetAccount());
			dto.setAmount(txn.getAmount());
			dto.setTimestamp(txn.getTimestamp());
			allTransaction.add(dto);
		}
		
		for(Transaction txn : credit) {
			TransactionDTO dto =  new TransactionDTO();
			dto.setTransactionType("CREDIT");
			dto.setFromAccount(txn.getSourceAccount());
			dto.setToAccount(txn.getTargetAccount());
			dto.setAmount(txn.getAmount());
			dto.setTimestamp(txn.getTimestamp());
			allTransaction.add(dto);
		}
		
		Collections.sort(allTransaction,(a,b)->b.getTimestamp().compareTo(a.getTimestamp()));
		
		return allTransaction;
	}
	
		
	}
	
	
	
	


