package com.example.financial_Analyzer.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthlySpend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String month;
	private long customer_Number;
	private float total_Incoming;
	private float total_Outgoing;
	private float closing_balance;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public long getCustomer_Number() {
		return customer_Number;
	}
	public void setCustomer_Number(long customer_Number) {
		this.customer_Number = customer_Number;
	}
	public float getTotal_Incoming() {
		return total_Incoming;
	}
	public void setTotal_Incoming(float total_Incoming) {
		this.total_Incoming = total_Incoming;
	}
	public float getTotal_Outgoing() {
		return total_Outgoing;
	}
	public void setTotal_Outgoing(float total_Outgoing) {
		this.total_Outgoing = total_Outgoing;
	}
	public float getClosing_balance() {
		return closing_balance;
	}
	public void setClosing_balance(float closing_balance) {
		this.closing_balance = closing_balance;
	}
	
}
