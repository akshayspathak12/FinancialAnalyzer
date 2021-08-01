package com.example.financial_Analyzer.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_Analyzer.Entities.MonthlySpend;
import com.example.financial_Analyzer.Entities.TransactionDetail;

import com.example.financial_Analyzer.Service.UserService;
import com.example.financial_Analyzer.dto.MonthlySpendDto;
import com.example.financial_Analyzer.dto.TransactionDetailDto;
import com.example.financial_Analyzer.web.UserRestAPI;

@RestController
public class UserRestController implements UserRestAPI {
	
	@Autowired
	private UserService userService;
	
	public TransactionDetail postData(@Valid @RequestBody TransactionDetailDto detail) throws Exception{
				TransactionDetail save = userService.saveData(detail);
				return save;
	}
	
	public List<TransactionDetailDto> getData() {
		List<TransactionDetailDto> findAll = userService.findAllData();
		return findAll;
		
	}
	
	
	public MonthlySpend postMonthlyData(@RequestBody MonthlySpendDto detail) throws Exception {
				MonthlySpend save = userService.saveMonthlyData(detail);
				return save;
	}
	
	public List<TransactionDetailDto> getIncomeData(@PathVariable("paymentCategory") String paymentCategory) {
		List<TransactionDetailDto> IncomeData = userService.findIncomeData(paymentCategory);
		return IncomeData;
	}
	
	public List<TransactionDetailDto> getExpensesData(@PathVariable("paymentCategory") String paymentCategory) {
		List<TransactionDetailDto> expensesData = userService.findExpenseData(paymentCategory);
		return expensesData;
	}
	
	public List<MonthlySpendDto> getMonthData() {
				List<MonthlySpendDto> findAll = userService.findAllMonthlyData();
				return findAll;
	}

}
