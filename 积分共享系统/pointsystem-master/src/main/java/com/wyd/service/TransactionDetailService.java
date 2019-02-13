package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.TransactionDetail;

@WebService
public interface TransactionDetailService{
	TransactionDetail load(int id);
	
	TransactionDetail get(int id);
	
	List<TransactionDetail> findAll();
	
	void persist(TransactionDetail transactionDetail);
	
	Integer save(TransactionDetail transactionDetail);
	
	void saveOrUpdate(TransactionDetail transactionDetail);
	
	void delete(int id);
	
	void flush();
}
