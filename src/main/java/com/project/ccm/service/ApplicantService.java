package com.project.ccm.service;

import java.util.List;

import com.project.ccm.entity.Applicant;

public interface ApplicantService {
	List<Applicant> getAllApplicants();

	Applicant saveApplicant(Applicant applicant);

	Applicant updateApplicant(String phone, String Address, String cardType);

	List<Applicant> getApplicantByPhone(String phone);
}
