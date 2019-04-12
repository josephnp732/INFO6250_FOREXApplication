package com.neu.edu.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {

    public Transaction() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    
    @Column(name = "transactionAmount")
    @DecimalMin(value="0.5", message="Please enter a valid Amount")
    @DecimalMax(value="9999999.9999", message="Please enter a valid Amount")
    private float transactionAmount;
    
    @Column(name = "transactionCurrency")
    private String transactionCurrency;

    public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	@Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "transactionDateTime")
    @Temporal(TemporalType.DATE)
    private Date transactionDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

}
