package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.ProductMembership;

@WebService
public interface ProductMembershipService{
	ProductMembership load(int id);
	
	ProductMembership get(int id);
	
	List<ProductMembership> findAll();
	
	void persist(ProductMembership productMembership);
	
	Integer save(ProductMembership productMembership);
	
	void saveOrUpdate(ProductMembership productMembership);
	
	void delete(int id);
	
	void flush();
}
