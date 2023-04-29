package com.project.ccm.service.impl;

import java.util.Collection;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ccm.entity.Applicant;
import com.project.ccm.repository.ApplicantRepository;
import com.project.ccm.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantRepository applicantRepository;

	public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
		super();
		this.applicantRepository = applicantRepository;
	}

	@Override
	public List<Applicant> getAllApplicants() {
		return applicantRepository.findAll();
	}

	@Override
	public List<Applicant> getApplicantByPhone(String phone) {
		return applicantRepository.findByPhone(phone);
	}

	@Override
	public Applicant saveApplicant(Applicant applicant) {
		Collection<Applicant> applicants = applicantRepository.findByPhone(applicant.getPhone());
		if (!applicants.isEmpty()) {
			return null;
		} else {

			return applicantRepository.save(applicant);
		}
	}

	@Override
	public Applicant updateApplicant(String phone, String address, String cardType) {
		List<Applicant> mod_applicant = applicantRepository.findByPhone(phone);
		if (!mod_applicant.isEmpty()) {
			Applicant applicants = mod_applicant.get(0);
			applicants.setAddress(address);
			applicants.setCardType(cardType);
			return applicantRepository.save(applicants);
		} else {
			return null;
		}
	}
}