package com.account.pc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.pc.model.Account;
import com.account.pc.model.Txn;
import com.account.pc.model.TxnType;
import com.account.pc.repository.AccountRepository;
import com.account.pc.repository.AccountRepositoryImpl;
import com.account.pc.repository.TxnRepository;

@Service
public class TxrServiceImpl implements TxrService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TxnRepository txnRepository;

	@Transactional
	public Txn txr(double amount, String fromAccNum, String toAccNum) {
		try {
			
			//System.out.println("here also");
			Account fromAccount = accountRepository.load(fromAccNum);
			Account toAccount = accountRepository.load(toAccNum);
			//System.out.println(fromAccount.getBalance());
			
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			System.out.println("here also");
			fromAccount = accountRepository.update(fromAccount);
			toAccount = accountRepository.update(toAccount);

			Txn debitTxn = new Txn();
			debitTxn.setAmount(amount);
			debitTxn.setType(TxnType.DEBIT);
			debitTxn.setDate(new Date());
			debitTxn.setClosingBalance(fromAccount.getBalance());
			debitTxn.setAccount(fromAccount);

			Txn creditTxn = new Txn();
			creditTxn.setAmount(amount);
			creditTxn.setType(TxnType.CREDIT);
			creditTxn.setDate(new Date());
			creditTxn.setClosingBalance(toAccount.getBalance());
			creditTxn.setAccount(toAccount);

			Txn txn=txnRepository.save(debitTxn);
			txnRepository.save(creditTxn);
			return txn;
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
