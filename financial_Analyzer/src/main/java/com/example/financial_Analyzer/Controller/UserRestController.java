package com.example.financial_Analyzer.Controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_Analyzer.Entities.MonthlySpend;
import com.example.financial_Analyzer.Entities.TransactionDetail;
import com.example.financial_Analyzer.Reposities.MonthlySpendRepository;
import com.example.financial_Analyzer.Reposities.TransactionDetailRepo;




@RestController
public class UserRestController {
	
	@Autowired
	private TransactionDetailRepo transactionRepo;
	
	@Autowired
	private MonthlySpendRepository monthlySpendRepo;
	
	@PostMapping("/transaction")
	public TransactionDetail postData(@RequestBody TransactionDetail detail) {
				TransactionDetail save = transactionRepo.save(detail);
				return save;
	}
	
	@GetMapping("/transactions")
	public List<TransactionDetail> getData() {
	
		List<TransactionDetail> findAll = transactionRepo.findAll();
		
		return findAll;
		
	}
	
	
	@PostMapping("/monthlySpend")
	public MonthlySpend postMonthlyData(@RequestBody MonthlySpend detail) {
				MonthlySpend save = monthlySpendRepo.save(detail);
				return save;
	}
	
	@GetMapping("/Income/{paymentCategory}")
	public List<TransactionDetail> getIncomeData(@PathVariable("paymentCategory") String paymentCategory) {
		List<TransactionDetail> findIncome = transactionRepo.findIncome(paymentCategory);
		
		return findIncome;
	}
	
	
	@GetMapping("/Expenses/{paymentCategory}")
	public List<TransactionDetail> getExpensesData(@PathVariable("paymentCategory") String paymentCategory) {
		List<TransactionDetail> findIncome = transactionRepo.findIncome(paymentCategory);
		
		return findIncome;
	}
	
	@GetMapping("/threeMonthIncomeAndExpenses")
	public List<MonthlySpend> getMonthData() {
				List<MonthlySpend> findAll = monthlySpendRepo.findAll();
				return findAll;
	}

}
