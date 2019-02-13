package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.TransPayment;

@WebService
public interface TransPaymentService{
	TransPayment load(int id);
	
	TransPayment get(int id);
	
	List<TransPayment> findAll();
	
	void persist(TransPayment transPayment);
	
	Integer save(TransPayment transPayment);
	
	void saveOrUpdate(TransPayment transPayment);
	
	void delete(int id);
	
	void flush();
}
