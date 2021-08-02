package com.example.financial_Analyzer.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.TransactionalException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource;

import com.example.financial_Analyzer.Entities.MonthlySpend;
import com.example.financial_Analyzer.Entities.TransactionDetail;
import com.example.financial_Analyzer.Exception.ExpensesNotFoundException;
import com.example.financial_Analyzer.Exception.IncomeNotFoundException;
import com.example.financial_Analyzer.Exception.MonthlyDataNotFoundException;
import com.example.financial_Analyzer.Exception.TransactionsNotFoundException;
import com.example.financial_Analyzer.Reposities.MonthlySpendRepository;
import com.example.financial_Analyzer.Reposities.TransactionDetailRepo;
import com.example.financial_Analyzer.dto.MonthlySpendDto;
import com.example.financial_Analyzer.dto.TransactionDetailDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TransactionDetailRepo transactionRepo;
	
	@Autowired
	private MonthlySpendRepository monthlySpendRepo;
	
	
	//adds the entries to the DB using ORM
	@Override
	public TransactionDetail saveData(TransactionDetailDto detail) throws Exception {
		if(detail.getCustomer_Id()==0||detail.getTransaction_Description()==""||detail.getAmount()==0||detail.getPayment_Type()==""||detail.getCategory()=="")
			throw new Exception("enter valid details");
		TransactionDetail save = transactionRepo.save(new TransactionDetail(detail.getCustomer_Id(),detail.getTransaction_Description() ,detail.getAmount() , detail.getPayment_Type(), detail.getCategory(), detail.getDate()));
		return save;
	}


	//provides the list of transactions
	@Override
	public List<TransactionDetailDto> findAllData() {
		List<TransactionDetailDto> list = new ArrayList<>();
		
		List<TransactionDetail> findAll = transactionRepo.findAll();
		for (TransactionDetail transactionDetail : findAll) {
			list.add(new TransactionDetailDto(transactionDetail.getCustomer_Id(), transactionDetail.getTransaction_Description(), transactionDetail.getAmount(), transactionDetail.getPayment_Type(), transactionDetail.getCategory(),transactionDetail.getDate()));
			
		}
		if (!list.isEmpty()) {
			return list;
		}
		else {
			throw new TransactionsNotFoundException("No Transaction Available");
			
		}
		
	}

	//add monthly data
	@Override
	public MonthlySpend saveMonthlyData(MonthlySpendDto detail) throws Exception {
		if(detail.getTotal_Incoming()==0.0||detail.getCustomer_Number()==0.0||detail.getTotal_Outgoing()==0.0||detail.getClosing_balance()==0.0||detail.getMonth()=="")
			throw new Exception("enter valid details");
		MonthlySpend save = monthlySpendRepo.save(new MonthlySpend(detail.getMonth(), detail.getCustomer_Number(), detail.getTotal_Incoming(), detail.getTotal_Outgoing(), detail.getClosing_balance()));
		return save;
	}


	//returns all transaction details for provided income source
	@Override
	public List<TransactionDetailDto> findIncomeData(String paymentCategory) {
		List<TransactionDetailDto> list = new ArrayList<>();
		List<TransactionDetail> findIncome = transactionRepo.findIncome(paymentCategory);
		for (TransactionDetail transactionDetail : findIncome) {
			if (transactionDetail.getPayment_Type().equals("credit")) {
				list.add(new TransactionDetailDto(transactionDetail.getCustomer_Id(), transactionDetail.getTransaction_Description(), transactionDetail.getAmount(), transactionDetail.getPayment_Type(), transactionDetail.getCategory(),transactionDetail.getDate()));
			}
		}
		if (list.isEmpty()) {
			throw new IncomeNotFoundException("No Income Transaction Available");
		}
		return list;
	}


	//returns all expenses as per provided expense type
	@Override
	public List<TransactionDetailDto> findExpenseData(String paymentCategory) {
		List<TransactionDetailDto> list = new ArrayList<>();
		List<TransactionDetail> findIncome = transactionRepo.findIncome(paymentCategory);
		for (TransactionDetail transactionDetail : findIncome) {
			if (transactionDetail.getPayment_Type().equals("debit")) {
				list.add(new TransactionDetailDto(transactionDetail.getCustomer_Id(), transactionDetail.getTransaction_Description(), transactionDetail.getAmount(), transactionDetail.getPayment_Type(), transactionDetail.getCategory(),transactionDetail.getDate()));
			}
		}
		if (list.isEmpty()) {
			throw new ExpensesNotFoundException("No Expenses Transaction Available");
		}
		return list;
	}


	//returns monthly data 
	@Override
	public List<MonthlySpendDto> findAllMonthlyData() {
		List<MonthlySpendDto> list = new ArrayList<>();
		List<MonthlySpend> findAll = monthlySpendRepo.findAll();
		for (MonthlySpend monthlyDetail : findAll) {
			list.add(new MonthlySpendDto(monthlyDetail.getMonth(), monthlyDetail.getCustomer_Number(), monthlyDetail.getTotal_Incoming(), monthlyDetail.getTotal_Outgoing(), monthlyDetail.getClosing_balance()));
		}
		if (list.isEmpty()) {
			throw new MonthlyDataNotFoundException("No Monthly Transaction Available");
		}
		return list;
		
	}

}
