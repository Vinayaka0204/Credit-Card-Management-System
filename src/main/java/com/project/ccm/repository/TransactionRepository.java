package com.project.ccm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ccm.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
	List<Transactions> findAllByPhone(String phone);
}
