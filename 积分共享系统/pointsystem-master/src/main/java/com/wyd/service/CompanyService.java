package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Company;

@WebService
public interface CompanyService{
	Company load(int id);
	
	Company get(int id);
	
	List<Company> findAll();
	
	void persist(Company company);
	
	Integer save(Company company);
	
	void saveOrUpdate(Company company);
	
	void delete(int id);
	
	void flush();
}
