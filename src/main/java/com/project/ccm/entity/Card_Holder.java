package com.project.ccm.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Card_Holder")
public class Card_Holder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "cardType")
	private String cardType;
	@Column(name = "cardLimit")
	private Double cardLimit;
	@Column(name = "balance")
	private Double balance;
	@Column(name = "lastTransaction")
	private Double lastTransaction;

	public Double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(Double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public Card_Holder() {
	}

	public Card_Holder(Applicant applicant) {
		this.name = applicant.getName();
		this.phone = applicant.getPhone();
		this.cardType = applicant.getCardType();
		this.cardLimit = getCardLimit(this.cardType);
		this.balance = this.cardLimit;
		this.lastTransaction = 0.0;
	}

	// getters and setters

	public Double getCardLimit(String cardType) {
		if (cardType.equalsIgnoreCase("silver")) {
			return 10000.0;
		} else if (cardType.equalsIgnoreCase("gold")) {
			return 50000.0;
		} else if (cardType.equalsIgnoreCase("platinum")) {
			return 100000.0;
		} else {
			return 0.0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Double getLastTransaction() {
		return lastTransaction;
	}

	public void setLastTransaction(Double lastTransaction) {
		this.lastTransaction = lastTransaction;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
