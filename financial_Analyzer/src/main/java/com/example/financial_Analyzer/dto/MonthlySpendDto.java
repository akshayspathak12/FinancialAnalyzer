package com.example.financial_Analyzer.dto;


import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class MonthlySpendDto {
	
	@NotNull
	private String month ;
	@NotNull
	private long customer_Number;
	@NotBlank
	private float total_Incoming;
	@NotNull
	private float total_Outgoing;
	@NotNull
	private float closing_balance;
	
	
	
	public MonthlySpendDto() {
		
	}
	public MonthlySpendDto(String month, long customer_Number, float total_Incoming, float total_Outgoing,
			float closing_balance) {
		
		this.month = month;
		this.customer_Number = customer_Number;
		this.total_Incoming = total_Incoming;
		this.total_Outgoing = total_Outgoing;
		this.closing_balance = closing_balance;
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
