package com.training.bank.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MiniStatement {
	
	private List<Transaction>transaction;
	private List<Withdraw>withdraw;
	private List<Deposit>deposit;
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public List<Withdraw> getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(List<Withdraw> withdraw) {
		this.withdraw = withdraw;
	}
	public List<Deposit> getDeposit() {
		return deposit;
	}
	public void setDeposit(List<Deposit> deposit) {
		this.deposit = deposit;
	}

	
	
	
	

}
