package com.neu.edu.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment implements Serializable{

	public Payment() {
		
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	
	@Column(name = "nameOnCard")
	private String nameOnCard;
	
	@Column(name = "cardType")
	private String cardType;
	
	@Column(name = "cardNumber")
	private long cardNumber;
	
	@Column(name = "cvv")
	private int cvv;
	
	@Column(name = "month")
	private int month;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "zipCode")
	private int zipCode;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return cardType + " Last 4 Digits - " + String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length() - 4);
	}
}
