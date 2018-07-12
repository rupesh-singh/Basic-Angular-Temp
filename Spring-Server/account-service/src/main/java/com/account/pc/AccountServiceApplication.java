package com.account.pc;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.account.pc.model.Account;
import com.account.pc.model.Txn;
import com.account.pc.model.TxnType;
import com.account.pc.repository.AccountRepository;
import com.account.pc.repository.TxnRepository;
import com.account.pc.service.TxrService;
import com.account.pc.service.TxrServiceImpl;

@SpringBootApplication
@EnableTransactionManagement
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	 @Bean
	 public CommandLineRunner test(AccountRepository accountRepository,	 TxnRepository txnRepository, TxrService txrService) {
	 return args -> {
	 };
	 }
}
