package com.training.bank.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bank.Service.ServiceImpl;
import com.training.bank.model.Account;
import com.training.bank.model.Customer;
import com.training.bank.model.Locker;
import com.training.bank.model.Login;
import com.training.bank.model.MiniStatement;

@RestController
@RequestMapping("/bank/v1")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
//	@Autowired
//	CustomerRepo crepo;
//	@Autowired
//	AccountRepo arepo;
	@Autowired
	ServiceImpl service;
	
	@GetMapping(path = "/customer")
	public List<Customer> getAllCustomers() {
		return service.getCustomers();
	}
	@GetMapping(path = "/account")
	public List<Account> getAllAccounts() {
		return service.getAccount();
	}
	@GetMapping(path = "/account/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Account getAccount(@PathVariable Long id) {
		return service.getAccountDetails(id);
	}
//	
	@GetMapping(path = "/customer/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomerbyId(@PathVariable String id){
		return service.getCustomer(Long.parseLong(id));
	}
	
	 @PostMapping(path="/customer",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public boolean createCustomer(@RequestBody Customer customer){
		 
		  if(customer.getLocker()) {
			  Iterator<Account> iterator = customer.getAccount().iterator();
			  Account account = iterator.next();
			  Locker locker = new Locker();
			  locker.setAvailable(true);
			  account.setLocker(locker);
			  
		  }
		 return service.saveCustomer(customer);
	 }
	 @PutMapping(path = "/customer/{id}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public boolean updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {
		 return service.updateCustomer(id, customer);
	 }
	 @DeleteMapping(path = "/customer/{id}")
	 public boolean deleteCustomer(@PathVariable Long id) {
		 return service.deleteCustomer(id);
		 
		 
	 }
	 @PostMapping(path="/transaction",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public Account getTransaction(@RequestBody Account account) {
		 return service.transactionDetail(account);
	 }
	 
	 
	 @PostMapping(path="/withdraw",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public Account getWithdraw(@RequestBody Account account) {
		 return service.withdraw(account);
	 }
	 
	 @PostMapping(path="/deposit",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public Account getDeposit(@RequestBody Account account) {
		 return service.deposit(account);
	 }
	 
	 @GetMapping(path = "/statement/{id}/{date}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
		public MiniStatement getAccount(@PathVariable("id") Long id,@PathVariable("date") String date) {
			return service.getStatement(id, date);
	 }
	 
	 
	 @PostMapping(path="/login")
	 public Customer Login(@RequestBody Login login) {
		 return service.signIn(login);
	 }
	 
	 @PutMapping(path = "/cust/{id}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public boolean changePassword(@PathVariable Long id,@RequestBody Customer customer) {
		 return service.changePassword(id, customer);
	 }
	 
	 @PostMapping(path="/addAccount/{id}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	 public boolean addAccount(@PathVariable Long id, @RequestBody Account account) {
		 return service.addAccount(account, id);
	 }
	 
	 @DeleteMapping(path = "/account/{id}")
	 public boolean deleteAccount(@PathVariable Long id) {
		 return service.deleteAccount(id);
		 
	 }
}
	 
