package com.training.bank.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.bank.DAO.DAO;
import com.training.bank.model.Account;
import com.training.bank.model.Customer;
import com.training.bank.model.Login;
import com.training.bank.model.MiniStatement;

@Service
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	DAO dao;

	@Override
	public boolean saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.saveCustomer(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}

	@Override
	public Account getAccountDetails(Long id) {
		// TODO Auto-generated method stub
		return dao.getAccountDetails(id);
	}

	@Override
	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return dao.getCustomer(id);
	}

	@Override
	public boolean updateCustomer(Long id, Customer customer) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(id, customer);
	}

	@Override
	public boolean deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(id);
	}

	@Override
	public Account transactionDetail(Account account) {
		// TODO Auto-generated method stub
		return dao.transactionDetail(account);
	}

	@Override
	public Account withdraw(Account account) {
		// TODO Auto-generated method stub
		return dao.withdraw(account);
	}

	@Override
	public Account deposit(Account account) {
		// TODO Auto-generated method stub
		return dao.deposit(account);
	}

	@Override
	public MiniStatement getStatement(Long id, String date) {
		// TODO Auto-generated method stub
		return dao.getStatement(id, date);
	}

	@Override
	public Customer signIn(Login login) {
		// TODO Auto-generated method stub
		return dao.signIn(login);
	}

	@Override
	public boolean addAccount(Account account, Long id) {
		// TODO Auto-generated method stub
		return dao.addAccount(account, id);
	}

	public List<Account> getAccount() {
		// TODO Auto-generated method stub
		return dao.getAccount();
	}

	public boolean changePassword(Long id, Customer customer) {
		// TODO Auto-generated method stub
		return dao.changePassword(id, customer);
	}

	public boolean deleteAccount(Long id) {
		// TODO Auto-generated method stub
		 return dao.deleteAccount(id);
	}

}
