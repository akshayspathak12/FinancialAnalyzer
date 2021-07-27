package com.example.financial_Analyzer.Reposities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financial_Analyzer.Entities.MonthlySpend;

public interface MonthlySpendRepository extends JpaRepository<MonthlySpend, Long> {

}
