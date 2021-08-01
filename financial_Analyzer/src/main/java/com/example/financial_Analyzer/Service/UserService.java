package com.example.financial_Analyzer.Service;

import java.util.List;

import com.example.financial_Analyzer.Entities.MonthlySpend;
import com.example.financial_Analyzer.Entities.TransactionDetail;
import com.example.financial_Analyzer.Exception.ExpensesNotFoundException;
import com.example.financial_Analyzer.Exception.IncomeNotFoundException;
import com.example.financial_Analyzer.Exception.MonthlyDataNotFoundException;
import com.example.financial_Analyzer.dto.MonthlySpendDto;
import com.example.financial_Analyzer.dto.TransactionDetailDto;

public interface UserService {

	TransactionDetail saveData(TransactionDetailDto detail) throws Exception;

	List<TransactionDetailDto> findAllData() ;

	MonthlySpend saveMonthlyData(MonthlySpendDto detail) throws Exception;

	List<TransactionDetailDto> findIncomeData(String paymentCategory) throws IncomeNotFoundException;

	List<TransactionDetailDto> findExpenseData(String paymentCategory) throws ExpensesNotFoundException;

	List<MonthlySpendDto> findAllMonthlyData() throws MonthlyDataNotFoundException;

}
