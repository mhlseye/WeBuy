package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.MembershipDao;
import com.wyd.dao.PointsAccountDao;
import com.wyd.domain.Membership;
import com.wyd.domain.PointsAccount;
import com.wyd.service.MembershipService;
import com.wyd.service.PointsAccountService;

@Service("membershipService")
@WebService(endpointInterface = "com.wyd.service.MembershipService") 
public class MembershipServiceImpl implements MembershipService{
	@Resource
	private MembershipDao membershipDao;
	@Resource
	private PointsAccountDao pointsAccountDao;
	
	@Resource
	private PointsAccountService pointsAccountService;

	public List<Membership> findAll() {
		return membershipDao.findAll();
	}

	@Override
	public Membership load(@WebParam(name = "id")int id) {
		return membershipDao.load(id);
	}

	@Override
	public Membership get(@WebParam(name = "id")int id) {
		return membershipDao.get(id);
	}

	@Override
	public void persist(Membership membership) {
		membershipDao.persist(membership);
	}

	@Override
	public Integer save(Membership membership) {
		int status = 1;
		PointsAccount pointsAccount = new PointsAccount();
		pointsAccount.setMembership(membership);
		pointsAccountDao.save(pointsAccount);
		membershipDao.save(membership);
		return status;
	}

	@Override
	public void saveOrUpdate(Membership membership) {
		membershipDao.saveOrUpdate(membership);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		membershipDao.delete(id);
	}

	@Override
	public void flush() {
		membershipDao.flush();
	}

	@Override
	public Membership getMembershipByCellPhone(String cellPhone) {
		return membershipDao.getMembershipByCellPhone(cellPhone);
	}

	@Override
	public Integer getPointsTotalByCellPhone(String cellPhone) {
		int status = 1;
		Membership membership = getMembershipByCellPhone(cellPhone);
		Integer pointsTotal = membershipDao.getPointsTotal(membership.getMembershipId());
		if(pointsTotal == null) {
			status = -1;
			return status;
		}
		return pointsTotal;
	}
	
	public Integer pointsDeposit(String cellPhone,int depositPoints) {
		int status = 1;
		Membership membership = getMembershipByCellPhone(cellPhone);
		int pointsTotal = getPointsTotalByCellPhone(cellPhone) + depositPoints;
		membershipDao.setPointsTotal(membership.getMembershipId(), pointsTotal);
		return status;
	}
	
	public Integer pointsSpend(String cellPhone,int spendPoints) {
		int status = 1;
		Membership membership = getMembershipByCellPhone(cellPhone);
		int pointsTotal = getPointsTotalByCellPhone(cellPhone);
		if(spendPoints > pointsTotal) {
			status = 0;
		}else {
			pointsTotal -= spendPoints;
			membershipDao.setPointsTotal(membership.getMembershipId(), pointsTotal);
		}
		return status;
	}
	
}
