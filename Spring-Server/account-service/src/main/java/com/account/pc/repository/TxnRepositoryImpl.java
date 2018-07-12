package com.account.pc.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.account.pc.controller.TxrRequest;
import com.account.pc.model.Account;
import com.account.pc.model.Txn;
import com.account.pc.model.TxnType;

@Transactional
@Repository(value = "txnRepository")
public class TxnRepositoryImpl implements TxnRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Txn save(Txn txn) {
		System.out.println("here");
		return entityManager.merge(txn);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Txn> findAll() {
		return entityManager.createQuery("from Txn").getResultList();
	}

}
