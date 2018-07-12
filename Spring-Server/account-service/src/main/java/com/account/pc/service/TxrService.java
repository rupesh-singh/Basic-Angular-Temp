package com.account.pc.service;

import com.account.pc.model.Txn;
import com.account.pc.repository.AccountRepository;
import com.account.pc.repository.TxnRepository;


public interface TxrService {

	Txn txr(double amount, String fromAccNum, String toAccNum);
}
