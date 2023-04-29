package com.project.ccm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ccm.entity.Card_Holder;

public interface CardHolderRepository extends JpaRepository<Card_Holder, Long> {
	List<Card_Holder> findByPhone(String phone);
}
