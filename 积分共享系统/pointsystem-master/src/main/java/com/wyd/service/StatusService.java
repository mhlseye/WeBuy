package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Status;

@WebService
public interface StatusService{
	Status load(int id);
	
	Status get(int id);
	
	List<Status> findAll();
	
	void persist(Status status);
	
	Integer save(Status status);
	
	void saveOrUpdate(Status status);
	
	void delete(int id);
	
	void flush();
}
