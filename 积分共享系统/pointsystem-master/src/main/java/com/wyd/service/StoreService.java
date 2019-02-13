package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Store;

@WebService
public interface StoreService {
	Store load(int id);
	
	Store get(int id);
	
	List<Store> findAll();
	
	void persist(Store store);
	
	Integer save(Store store);
	
	void saveOrUpdate(Store store);
	
	void delete(int id);
	
	void flush();
}
