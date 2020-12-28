package com.training.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String acc_no;
	private String acc_type;
	private Double balance;
	private String branchName;
	private String branchCode;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Locker locker;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Transaction.class)
	List<Transaction>transaction;
//	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	private Customer customer;
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL,targetEntity = Withdraw.class)
	List<Withdraw>withdraw;
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL,targetEntity = Deposit.class)
	List<Deposit>deposit;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

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
	
	
	
	
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
	

	
	
}