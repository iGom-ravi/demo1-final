package com.example.demo1.demo1.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.demo1.service.AccountOpenBalanceService;
import com.example.demo1.demo1.values.AccountOpenBalance;


@RestController
public class AccountBalanceController {
	
	@Autowired
	AccountOpenBalanceService accountBalanceService;
	AccountOpenBalance accountOpenBalance;
	
	@GetMapping("/bal")
	public List<AccountOpenBalance> fetchBalance() {
		return accountBalanceService.getAccountBalance();
	}
	@GetMapping("/bal/{id}")
	public Optional<AccountOpenBalance> fetchUser(@PathVariable("id") int id){
		return accountBalanceService.getAccountUser(id);	
	}
	@PostMapping("/books")  
	public int saveBook(@RequestBody AccountOpenBalance books)   
	{  
	accountBalanceService.saveUpdate(books);  
	return books.getAccBal();  
	}  
	@PutMapping("/put")
	public AccountOpenBalance putcheck(@RequestBody AccountOpenBalance books) {
		accountBalanceService.saveUpdate(books);
		return books;	
	}
	@DeleteMapping("/bal/{id}")
	public void deleteCheck(@PathVariable("id")int id ) {
		accountBalanceService.deleteData(id);
	}
}
