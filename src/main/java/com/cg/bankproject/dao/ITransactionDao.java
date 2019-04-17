package com.cg.bankproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankproject.model.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByCustomerId(int id);
}
