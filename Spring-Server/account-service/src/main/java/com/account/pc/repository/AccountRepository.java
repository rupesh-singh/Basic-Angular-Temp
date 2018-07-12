package com.account.pc.repository;

import java.util.List;

import com.account.pc.model.Account;

public interface AccountRepository {

	Account load(String num);

	Account update(Account account);

	List<Account> findAll();

}
