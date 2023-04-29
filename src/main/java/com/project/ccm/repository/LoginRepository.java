package com.project.ccm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ccm.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	List<Login> findByPhone(String phone);
}
