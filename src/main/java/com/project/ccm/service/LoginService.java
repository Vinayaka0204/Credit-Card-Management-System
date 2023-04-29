package com.project.ccm.service;

import com.project.ccm.entity.Login;

public interface LoginService {
	Login saveCredentials(String phone);

	boolean Validate(String phone);

	boolean ValidateAdmin(String phone);
}
