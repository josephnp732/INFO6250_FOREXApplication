package com.neu.edu.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//https://www.javainterviewpoint.com/hibernate-one-to-many-mapping-example-annotation/

@Entity
@Table(name="Users")
public class User implements Serializable{
	
	public User() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Recipient> getRecipients() {
		return recipients;
	}

	public void setRecipients(Set<Recipient> recipients) {
		this.recipients = recipients;
	}

	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Column(name = "name")
	@Pattern(regexp="[a-zA-Z ]*", message="Please enter a valid name  ")
	private String name;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "dateOfBirth")
	@Pattern(regexp="^((0|1)\\d{1})/((0|1|2)\\d{1})/((19|20)\\d{2})", message="Please enter a valid date (mm/DD/yyyy)  ")
	private String dateOfBirth;
	
	@Column(name = "email")
	@Pattern(regexp="[a-z0-9\\._%+!$&*=^|~#%'`?{}/\\-]+@([a-z0-9\\-]+\\.){1,}([a-z]{2,16})", message="Please enter a valid email")
	private String email;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Recipient> recipients = new HashSet<Recipient>();
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Payment> payment = new HashSet<Payment>();
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
