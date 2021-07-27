package com.example.financial_Analyzer.Reposities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.financial_Analyzer.Entities.TransactionDetail;



public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Long> {

	@Query("from TransactionDetail where category=:category ")
	List<TransactionDetail> findIncome( @Param("category") String paymentCategory);

	

}
