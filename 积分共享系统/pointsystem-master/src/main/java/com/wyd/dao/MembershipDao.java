package com.wyd.dao;

import com.wyd.domain.Membership;
import com.wyd.domain.PointsAccount;

public interface MembershipDao extends GenericDao<Membership>{
	Integer getPointsTotal(int id);
	
	Membership getMembershipByCellPhone(String cellPhone);
	
	PointsAccount getPointsAccountByMembershipId(int membershipId);
	
	Integer setPointsTotal(int membershipId,int pointsTotal);
}
