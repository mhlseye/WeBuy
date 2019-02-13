package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PaymentMethod;

@WebService
public interface PaymentMethodService{
	
	PaymentMethod load(int id);
	
	PaymentMethod get(int id);
	
	List<PaymentMethod> findAll();
	
	void persist(PaymentMethod paymentMethod);
	
	Integer save(PaymentMethod paymentMethod);
	
	void saveOrUpdate(PaymentMethod paymentMethod);
	
	void delete(int id);
	
	void flush();
}
