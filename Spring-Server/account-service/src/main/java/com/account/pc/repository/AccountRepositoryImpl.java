package com.account.pc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.account.pc.model.Account;

@Repository(value = "accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Account load(String num) {
		System.out.println("hello");
		return entityManager.find(Account.class, num);
		
	}

	@Override
	public List<Account> findAll() {
		// System.out.println("up and running");

		String jpql = "from Account";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public Account update(Account account) {
		return entityManager.merge(account);
	}

}
