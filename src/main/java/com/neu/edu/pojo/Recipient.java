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
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Recipient")
public class Recipient implements Serializable{
	
	public Recipient() {
		
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipientId; 
	
	@Column(name = "name")
	@Pattern(regexp="[a-zA-Z ]*", message="Please enter a valid name  ")
	private String name;
	
	@Column(name = "accountNumber")
	private long accountNumber;
	
	@Column(name = "routingNumber")
	private long routingNumber;
	
	@Column(name = "emailAddress")
	@Pattern(regexp="[a-z0-9\\._%+!$&*=^|~#%'`?{}/\\-]+@([a-z0-9\\-]+\\.){1,}([a-z]{2,16})", message="Please enter a valid email")
	private String emailAddress;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name="purpose")
	@Pattern(regexp="[a-zA-Z ]*", message="Please enter a valid relation  ")
	private String purpose;
	
	@Override
	public String toString() {
		return name + " - Acc. no: " + String.valueOf(accountNumber);
	}

}
