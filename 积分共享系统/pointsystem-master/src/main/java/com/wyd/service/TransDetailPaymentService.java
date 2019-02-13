package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.TransDetailPayment;

@WebService
public interface TransDetailPaymentService{
	TransDetailPayment load(int id);
	
	TransDetailPayment get(int id);
	
	List<TransDetailPayment> findAll();
	
	void persist(TransDetailPayment transDetailPayment);
	
	Integer save(TransDetailPayment transDetailPayment);
	
	void saveOrUpdate(TransDetailPayment transDetailPayment);
	
	void delete(int id);
	
	void flush();
}
