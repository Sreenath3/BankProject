package com.cg.bankproject.service;

import java.util.List;

import com.cg.bankproject.model.Transaction;

public interface ITransactionService {

	public List<Transaction> findByCustomerId(int id);
}
