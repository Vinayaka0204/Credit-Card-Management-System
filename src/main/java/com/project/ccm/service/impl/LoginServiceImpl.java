package com.project.ccm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ccm.entity.Applicant;
import com.project.ccm.entity.Login;
import com.project.ccm.repository.ApplicantRepository;
import com.project.ccm.repository.LoginRepository;
import com.project.ccm.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private ApplicantRepository applicantRepo;
	private LoginRepository loginRepo;

	public LoginServiceImpl(ApplicantRepository applicantRepo, LoginRepository loginRepo) {
		super();
		this.applicantRepo = applicantRepo;
		this.loginRepo = loginRepo;
	}

	@Override
	public boolean Validate(String phone) {
		List<Login> user = loginRepo.findByPhone(phone);
		if (user.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Login saveCredentials(String phone) {
		List<Applicant> applicants = applicantRepo.findByPhone(phone);
		if (!applicants.isEmpty()) {
			Applicant applicant = applicants.get(0);
			Login credentials = new Login(applicant);
			return loginRepo.save(credentials);
		} else {
			return null;
		}
	}

	@Override
	public boolean ValidateAdmin(String phone) {
		if (phone.equals("1231231231")) {
			return true;
		} else {
			return false;
		}
	}

}
