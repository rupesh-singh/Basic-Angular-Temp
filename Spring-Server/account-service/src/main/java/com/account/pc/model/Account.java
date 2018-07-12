package com.account.pc.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNTS", schema = "my_bank")
public class Account {

	@Id
	private String num;
	private String holder_name;
	private double balance;
	@Enumerated(EnumType.STRING)
	private AccountType type;

	@OneToMany(mappedBy="account",targetEntity=Txn.class)
	private List<Txn> transactions;

	public List<Txn> getTxns() {
		return transactions;
	}

	public void setTxns(List<Txn> txns) {
		this.transactions = txns;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getHolderName() {
		return holder_name;
	}

	public void setHolderName(String holderName) {
		this.holder_name = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

}
