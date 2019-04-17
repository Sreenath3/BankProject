package com.cg.bankproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankproject.model.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findByIdAndPassword(int id, String password);
}
