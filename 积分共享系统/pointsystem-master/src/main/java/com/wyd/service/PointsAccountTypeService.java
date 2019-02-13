package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PointsAccountType;

@WebService
public interface PointsAccountTypeService{
	PointsAccountType load(int id);
	
	PointsAccountType get(int id);
	
	List<PointsAccountType> findAll();
	
	void persist(PointsAccountType pointsAccountType);
	
	Integer save(PointsAccountType pointsAccountType);
	
	void saveOrUpdate(PointsAccountType pointsAccountType);
	
	void delete(int id);
	
	void flush();
}
