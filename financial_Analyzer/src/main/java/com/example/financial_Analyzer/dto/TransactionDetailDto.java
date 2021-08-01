package com.example.financial_Analyzer.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TransactionDetailDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long serialNo;
	@NotNull
	private long customer_Id;
	@NotNull
	private String transaction_Description;
	@NotNull
	private int amount;
	@NotNull
	private String payment_Type;
	@NotNull
	private String category;
	@NotNull
	private Date date;
	
	
	public TransactionDetailDto( long customer_Id, String transaction_Description, int amount,
			String payment_Type, String category, Date date) {
		super();
		this.customer_Id = customer_Id;
		this.transaction_Description = transaction_Description;
		this.amount = amount;
		this.payment_Type = payment_Type;
		this.category = category;
		this.date = date;
	}
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
