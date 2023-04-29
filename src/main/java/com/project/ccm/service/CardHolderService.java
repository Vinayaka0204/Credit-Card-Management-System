package com.project.ccm.service;

import java.util.List;

import com.project.ccm.entity.Applicant;
import com.project.ccm.entity.Card_Holder;

public interface CardHolderService {
	List<Card_Holder> getCardDetails(String phone);

	Card_Holder Transaction(String phone, Double transaction_amt);

	Card_Holder saveCardHolder(Applicant applicant);

	Card_Holder updateCardHolder(Applicant applicant);

}
