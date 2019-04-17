package com.cg.bankproject.service;

import java.util.List;

import com.cg.bankproject.model.Customer;
import com.cg.bankproject.model.Transaction;

public interface ICustomerService {

	public List<Customer> findAll();

	public void save(Customer customer);

	public Customer findById(Integer id);

	public Customer findByIdAndPassword(int id, String password);

}
