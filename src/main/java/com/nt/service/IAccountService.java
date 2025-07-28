package com.nt.service;

import java.util.List;

import com.nt.dto.AccountRequestDTO;
import com.nt.dto.AccountResponseDTO;
import com.nt.dto.FundTransferRequestDTO;
import com.nt.dto.FundTransferResponseDTO;
import com.nt.dto.TransactionDTO;

public interface IAccountService {

	AccountResponseDTO createAccount(AccountRequestDTO request);
	
	FundTransferResponseDTO transferFund(FundTransferRequestDTO request);
	
	double checkBalance(String accountNumber);
	
	List<TransactionDTO> getTransactionHistory(String accountNumber);
}
