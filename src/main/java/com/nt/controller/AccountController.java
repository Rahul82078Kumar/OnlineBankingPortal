package com.nt.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.OnlineBankingPortalApplication;
import com.nt.dto.AccountRequestDTO;
import com.nt.dto.AccountResponseDTO;
import com.nt.dto.FundTransferRequestDTO;
import com.nt.dto.FundTransferResponseDTO;
import com.nt.dto.TransactionDTO;
import com.nt.service.IAccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final OnlineBankingPortalApplication onlineBankingPortalApplication;

	@Autowired
	private IAccountService accountService;

    AccountController(OnlineBankingPortalApplication onlineBankingPortalApplication) {
        this.onlineBankingPortalApplication = onlineBankingPortalApplication;
    }
	
	@PostMapping("/create")
	public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO requestDTO){
		
		AccountResponseDTO response = accountService.createAccount(requestDTO);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<FundTransferResponseDTO> transferFund(@RequestBody FundTransferRequestDTO request){
		
		
		FundTransferResponseDTO response =accountService.transferFund(request);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/balance/{accountNumber}")
	public ResponseEntity<Double> getBalance(@PathVariable String accountNumber){
		
		double balance = accountService.checkBalance(accountNumber);
		
		return ResponseEntity.ok(balance);
	}
	
	
	
	@GetMapping("/transaction/{accountNumber}")
	public ResponseEntity<List<TransactionDTO>> getTransactionHistory(@PathVariable String accountNumber){
		List<TransactionDTO> history =accountService.getTransactionHistory(accountNumber);

		return new ResponseEntity(history,HttpStatus.OK);
	}
	
	
}
