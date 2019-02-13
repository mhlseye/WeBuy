package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.PointsDepositTransDetail;

@WebService
public interface PointsDepositTransDetailService{
	PointsDepositTransDetail load(int id);
	
	PointsDepositTransDetail get(int id);
	
	List<PointsDepositTransDetail> findAll();
	
	void persist(PointsDepositTransDetail pointsDepositTransDetail);
	
	Integer save(PointsDepositTransDetail pointsDepositTransDetail);
	
	void saveOrUpdate(PointsDepositTransDetail pointsDepositTransDetail);
	
	void delete(int id);
	
	void flush();
}
