package com.project.ccm.service;

import java.util.List;

import com.project.ccm.entity.Transactions;

public interface TransactionService {
	Transactions saveTransaction(Transactions transaction);

	List<Transactions> getAllTransactions(String phone);
}
