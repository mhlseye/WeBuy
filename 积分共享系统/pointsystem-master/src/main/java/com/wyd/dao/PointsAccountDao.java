package com.wyd.dao;

import java.sql.Date;

import com.wyd.domain.PointsAccount;

public interface PointsAccountDao extends GenericDao<PointsAccount>{
	
	void cleanPoints(int id,Date beginDate, Date endDate);
	
}
