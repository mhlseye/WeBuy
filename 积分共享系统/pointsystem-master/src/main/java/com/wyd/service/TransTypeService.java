package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.TransType;

@WebService
public interface TransTypeService{
	TransType load(int id);
	
	TransType get(int id);
	
	List<TransType> findAll();
	
	void persist(TransType transType);
	
	Integer save(TransType transType);
	
	void saveOrUpdate(TransType transType);
	
	void delete(int id);
	
	void flush();
}
