package com.account.pc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.pc.model.Account;
import com.account.pc.repository.AccountRepository;
import com.account.pc.repository.TxnRepository;
import com.account.pc.service.TxrService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="api/account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	
	@GetMapping(produces= {"application/json"})
	public List<Account> get() {
		List<Account> account = accountRepository.findAll();
		return account;
	}
	
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Account get(@PathVariable String id) {
		Account account = accountRepository.load(id);
		return account;
	}
	
	

}
