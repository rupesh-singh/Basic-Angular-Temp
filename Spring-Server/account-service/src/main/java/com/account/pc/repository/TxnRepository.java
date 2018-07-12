package com.account.pc.repository;

import java.util.List;

import com.account.pc.model.Txn;


public interface TxnRepository {
	Txn save(Txn txn);

	List<Txn> findAll();

	

}
