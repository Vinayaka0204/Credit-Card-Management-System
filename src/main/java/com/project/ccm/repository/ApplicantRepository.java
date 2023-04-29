package com.project.ccm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ccm.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	List<Applicant> findByPhone(String phone);
}
