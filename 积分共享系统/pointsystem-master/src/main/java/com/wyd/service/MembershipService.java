package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Membership;

@WebService
public interface MembershipService{
	
	Membership load(int id);
	
	Membership get(int id);
	
	List<Membership> findAll();
	
	void persist(Membership membership);
	
	Integer save(Membership membership);
	
	void saveOrUpdate(Membership membership);
	
	void delete(int id);
	
	void flush();
	
	Integer getPointsTotalByCellPhone(String cellPhone);
	
	Membership getMembershipByCellPhone(String cellPhone);
	
	Integer pointsDeposit(String cellPhone,int depositPoints);
	
	Integer pointsSpend(String cellPhone,int depositPoints);
	
}
