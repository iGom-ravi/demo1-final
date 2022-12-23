package com.example.demo1.demo1.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.demo1.controller.AccountBalanceController;
import com.example.demo1.demo1.repository.AccountRepository;
import com.example.demo1.demo1.values.AccountOpenBalance;



@Service
public class AccountOpenBalanceService {	
	@Autowired
	AccountRepository accountRepository;
	AccountOpenBalance accountOpenBalance;
	
	public List<AccountOpenBalance> getAccountBalance() {
		List<AccountOpenBalance> acc= new ArrayList<AccountOpenBalance>();
		accountRepository.findAll().forEach(b->acc.add(b));
		return acc;
		
	}
	public Optional<AccountOpenBalance> getAccountUser(int id) {
		return accountRepository.findById(id);	
	}
		
	
	public void saveUpdate(AccountOpenBalance accountBalanceService) {
		accountRepository.save(accountBalanceService);
		
	}
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
		
	}
	
	

}
