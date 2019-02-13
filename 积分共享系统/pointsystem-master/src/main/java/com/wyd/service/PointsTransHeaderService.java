package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PointsTransHeader;

@WebService
public interface PointsTransHeaderService{
	PointsTransHeader load(int id);
	
	PointsTransHeader get(int id);
	
	List<PointsTransHeader> findAll();
	
	void persist(PointsTransHeader pointsTransHeader);
	
	Integer save(PointsTransHeader pointsTransHeader);
	
	void saveOrUpdate(PointsTransHeader pointsTransHeader);
	
	void delete(int id);
	
	void flush();
}
