package com.cg.bankproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "banking1")
public class Customer {
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq80_cus_id", allocationSize = 1)
	private int id;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + ", password=" + password + "]";
	}

	private String name;
	private int balance;
	private String password;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Transaction> transaction = new HashSet<>();

	public Set<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setCustomer(this); // this will avoid nested cascade
		this.getTransaction().add(transaction);
	}

}
