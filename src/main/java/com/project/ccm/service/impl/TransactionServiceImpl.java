package com.project.ccm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ccm.entity.Transactions;
import com.project.ccm.repository.TransactionRepository;
import com.project.ccm.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	private TransactionRepository transactRepo;

	public TransactionServiceImpl(TransactionRepository transactRepo) {
		super();
		this.transactRepo = transactRepo;
	}

	@Override
	public List<Transactions> getAllTransactions(String phone) {
		if (!transactRepo.findAllByPhone(phone).isEmpty()) {
			return transactRepo.findAllByPhone(phone);
		} else {
			return null;
		}
	}

	@Override
	public Transactions saveTransaction(Transactions transaction) {
		return transactRepo.save(transaction);
	}

}
