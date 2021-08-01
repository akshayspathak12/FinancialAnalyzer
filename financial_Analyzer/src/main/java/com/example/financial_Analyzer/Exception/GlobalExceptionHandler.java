package com.example.financial_Analyzer.Exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.financial_Analyzer.Entities.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Request Method Not Supported");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Media Not Supported");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Path Variable is missing");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Request Param is missing");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Mismatch of type");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Request Body is not readable");
		ApiErrors error = new ApiErrors(message,detail,status, LocalDateTime.now());
		return ResponseEntity.status(status).body(error);
	}
	@ExceptionHandler(TransactionsNotFoundException.class)
	public ResponseEntity<Object> handleTransactionsNotFoundException(TransactionsNotFoundException ex){
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Transaction not Found");
		ApiErrors error = new ApiErrors(message,detail,HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(IncomeNotFoundException.class)
	public ResponseEntity<Object> handleIncomeNotFoundException(IncomeNotFoundException ex){
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Income Transaction not Found");
		ApiErrors error = new ApiErrors(message,detail,HttpStatus.NOT_FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ExpensesNotFoundException.class)
	public ResponseEntity<Object> handleExpensesNotFoundException(ExpensesNotFoundException ex){
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Expenses Transaction not Found");
		ApiErrors error = new ApiErrors(message,detail,HttpStatus.NOT_FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MonthlyDataNotFoundException.class)
	public ResponseEntity<Object> handleMonthlyDataNotFoundException(MonthlyDataNotFoundException ex){
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add(" Monthly Data not Found");
		ApiErrors error = new ApiErrors(message,detail,HttpStatus.NOT_FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception ex){
		String message = ex.getMessage();
		List<String> detail = new ArrayList<>();
		detail.add("Other Exception");
		ApiErrors error = new ApiErrors(message,detail,HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
