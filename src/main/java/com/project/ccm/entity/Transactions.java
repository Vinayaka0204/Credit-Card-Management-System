package com.project.ccm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {
	public Transactions(){};
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="phone")
	private String phone;
	@Column(name="transaction_amt")
	private Double transactionAmt ;
	
	public String getPhone() {
		return phone;
	}
	public Long getId() {
		return id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(Double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	
	public Transactions(String phone, Double transactionAmt) {
		super();
		this.phone = phone;
		this.transactionAmt = transactionAmt;
	}
	
}
