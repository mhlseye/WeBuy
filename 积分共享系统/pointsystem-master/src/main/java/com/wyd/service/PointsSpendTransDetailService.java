package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PointsSpendTransDetail;

@WebService
public interface PointsSpendTransDetailService{
	
	PointsSpendTransDetail load(int id);
	
	PointsSpendTransDetail get(int id);
	
	List<PointsSpendTransDetail> findAll();
	
	void persist(PointsSpendTransDetail pointsSpendTransDetail);
	
	Integer save(PointsSpendTransDetail pointsSpendTransDetail);
	
	void saveOrUpdate(PointsSpendTransDetail pointsSpendTransDetail);
	
	void delete(int id);
	
	void flush();
}
