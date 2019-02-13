package com.wyd.service;

import java.sql.Date;
import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PointsAccount;

@WebService
public interface PointsAccountService{
	
	PointsAccount load(int id);
	
	PointsAccount get(int id);
	
	List<PointsAccount> findAll();
	
	void persist(PointsAccount pointsAccount);
	
	Integer save(PointsAccount pointsAccount);
	
	void saveOrUpdate(PointsAccount pointsAccount);
	
	void delete(int id);
	
	void flush();
	
	void cleanPoints(int id,Date beginDate, Date endDate);
}
