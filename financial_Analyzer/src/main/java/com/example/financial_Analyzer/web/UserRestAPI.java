package com.example.financial_Analyzer.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.financial_Analyzer.Entities.MonthlySpend;
import com.example.financial_Analyzer.Entities.TransactionDetail;
import com.example.financial_Analyzer.dto.MonthlySpendDto;
import com.example.financial_Analyzer.dto.TransactionDetailDto;

public interface UserRestAPI {

	@RequestMapping(value = "/transaction",method = RequestMethod.POST)
	public TransactionDetail postData(@Valid @RequestBody TransactionDetailDto detail) throws Exception;
	
	@RequestMapping(value = "/transactions",method = RequestMethod.GET)
	public List<TransactionDetailDto> getData();
	
	@RequestMapping(value = "/monthlySpend",method = RequestMethod.POST)
	public MonthlySpend postMonthlyData( @RequestBody MonthlySpendDto detail) throws Exception;

	@RequestMapping(value = "/Income/{paymentCategory}",method = RequestMethod.GET)
	public List<TransactionDetailDto> getIncomeData(@PathVariable("paymentCategory") String paymentCategory);

	@RequestMapping(value = "/Expenses/{paymentCategory}",method = RequestMethod.GET)
	public List<TransactionDetailDto> getExpensesData(@PathVariable("paymentCategory") String paymentCategory);

	@RequestMapping(value = "/threeMonthIncomeAndExpenses",method = RequestMethod.GET)
	public List<MonthlySpendDto> getMonthData();
	


}
