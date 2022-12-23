package com.example.demo1.demo1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import com.example.demo1.demo1.values.AccountOpenBalance;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo1.demo1.controller.AccountBalanceController;
import com.example.demo1.demo1.repository.AccountRepository;
import com.example.demo1.demo1.service.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class Demo1ApplicationTests {

	 
	 @Autowired
	 AccountRepository accountRepository;
	 
	 AccountOpenBalance a = new AccountOpenBalance();
	 @BeforeAll
		static void before() {
			System.out.println("BeforeAll");
		}
	 @AfterAll
		static void after() {
			System.out.println("AfterAll");
		}
	 @BeforeEach
	 void beforeEach() {
		System.out.println("Beforeeach");
	}
	@AfterEach
	  void afterEach() {
		System.out.println("afterEach");
	}
	
	 @Test
	 @Order(1)
	 public void testRest() {
		
		 a.setAccBal(1000);
		 a.setAccType("savings");
		 a.setId(1);
		 a.setUserName("Gom");
		 accountRepository.save(a);
		 assertNotNull(accountRepository.findById(1).get()); 
	 }
	 
	 @Test
	 @Order(2)
	 public void restTest1() {
		 List<AccountOpenBalance> ls= (List<AccountOpenBalance>) accountRepository.findAll();
		 System.out.print(ls);
		 assertThat(ls).size().isGreaterThan(0);	 
	 }
	 
	 @Test
	 @Order(3)
	 public void readData() {
		 AccountOpenBalance aa=accountRepository.findById(1).get();
		// aa.setAccBal(1000);
		 assertEquals(2000, aa.getAccBal());
		 
	 }
	 
	 @Test
	 @Order(4)
	 public void readNotData() {
		 AccountOpenBalance aa=accountRepository.findById(1).get();
		aa.setAccBal(1000);
		accountRepository.save(aa);
		assertNotEquals(2000, aa.getAccBal());
	 }
	 
	 @Test
	 @Order(5)
	 public void delete() {
		 accountRepository.deleteById(1);
		 assertThat(accountRepository.existsById(1)).isFalse();
		 
	
	 }



}
