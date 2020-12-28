package com.training.bank.Service;

import java.util.List;

import com.training.bank.model.Account;
import com.training.bank.model.Customer;
import com.training.bank.model.Login;
import com.training.bank.model.MiniStatement;

public interface ServiceInterface {
	public boolean saveCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Account getAccountDetails(Long id);
	public Customer getCustomer(Long id);
	public boolean updateCustomer(Long id,Customer customer);
	public boolean deleteCustomer(Long id);
	public Account transactionDetail(Account account);
	public Account withdraw(Account account);
	public Account deposit(Account account);
	public MiniStatement getStatement(Long id,String date);
	public Customer signIn(Login login);
	public boolean addAccount(Account account,Long id);
	public boolean deleteAccount(Long id);
	public boolean changePassword(Long id,Customer customer);
	public List<Account> getAccount();
}
