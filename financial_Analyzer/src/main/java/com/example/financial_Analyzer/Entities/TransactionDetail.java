package com.example.financial_Analyzer.Entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long serialNo;
	private long customer_Id;
	private String transaction_Description;
	private int amount;
	private String payment_Type;
	private String category;
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(long customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getTransaction_Description() {
		return transaction_Description;
	}
	public void setTransaction_Description(String transaction_Description) {
		this.transaction_Description = transaction_Description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPayment_Type() {
		return payment_Type;
	}
	public void setPayment_Type(String payment_Type) {
		this.payment_Type = payment_Type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}


	
	
	

}
