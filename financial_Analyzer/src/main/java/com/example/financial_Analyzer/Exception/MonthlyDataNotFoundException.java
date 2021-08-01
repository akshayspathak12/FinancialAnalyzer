package com.example.financial_Analyzer.Exception;

public class MonthlyDataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonthlyDataNotFoundException() {
		super();
		
	}

	public MonthlyDataNotFoundException(String message) {
		super(message);
		
	}

}
