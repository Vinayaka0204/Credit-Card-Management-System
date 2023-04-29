package com.project.ccm.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ccm.entity.Applicant;
import com.project.ccm.entity.Card_Holder;
import com.project.ccm.repository.CardHolderRepository;
import com.project.ccm.service.CardHolderService;

@Service
public  class CardHolderServiceImpl implements CardHolderService{
	private CardHolderRepository cardHolderRep;
	
	public CardHolderServiceImpl(CardHolderRepository CardHolderRep) {
		super();
		this.cardHolderRep = CardHolderRep;
	}
	@Override
	public Card_Holder saveCardHolder(Applicant applicant) {
		Card_Holder user = new Card_Holder(applicant);
		return cardHolderRep.save(user);
	}
	@Override
	public Card_Holder updateCardHolder(Applicant applicant) {
		List<Card_Holder> users = cardHolderRep.findByPhone(applicant.getPhone());
		Card_Holder user = users.get(0);
		Double diff = user.getCardLimit()- user.getBalance();
		Double newCardLimit = user.getCardLimit(applicant.getCardType());
		user.setCardType(applicant.getCardType());
		user.setCardLimit(user.getCardLimit(applicant.getCardType()));
		user.setBalance(newCardLimit - diff);
		return cardHolderRep.save(user);
	}
	@Override
	public Card_Holder Transaction(String phone, Double transaction_amt) {
		List<Card_Holder> user = cardHolderRep.findByPhone(phone);
		Card_Holder cardHolder = user.get(0);
		Double Balance = cardHolder.getBalance();
		Balance -= transaction_amt;
		cardHolder.setLastTransaction(transaction_amt);
		cardHolder.setBalance(Balance);
		cardHolderRep.save(cardHolder);
		return cardHolder;
	}
	@Override
	public List<Card_Holder> getCardDetails(String phone) {
		List<Card_Holder> holder = cardHolderRep.findByPhone(phone);
			if(!holder.isEmpty()) {
				return holder;
			}
			else{return null;}
	}
	
	
	
}
