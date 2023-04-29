package com.project.ccm.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant {
	public Applicant() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "cardType")
	private String cardType;

	@Column(name = "status")
	private String status;

	public Applicant(String name, String phone, String address, String cardType, String status) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.cardType = cardType;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		status = "Pending";
		this.status = status;
	}
}
