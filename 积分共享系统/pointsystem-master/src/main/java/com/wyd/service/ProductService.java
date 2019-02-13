package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Product;

@WebService
public interface ProductService{
	Product load(int id);
	
	Product get(int id);
	
	List<Product> findAll();
	
	void persist(Product product);
	
	Integer save(Product product);
	
	void saveOrUpdate(Product product);
	
	void delete(int id);
	
	void flush();
}
