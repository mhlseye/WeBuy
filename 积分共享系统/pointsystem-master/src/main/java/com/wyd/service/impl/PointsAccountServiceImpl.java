package com.wyd.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PointsAccountDao;
import com.wyd.domain.PointsAccount;
import com.wyd.service.PointsAccountService;

@Service("pointsAccountService")
@WebService(endpointInterface = "com.wyd.service.PointsAccountService") 
public class PointsAccountServiceImpl implements PointsAccountService{
	@Resource
	private PointsAccountDao pointsAccountDao;

	@Override
	public PointsAccount load(@WebParam(name = "id")int id) {
		return pointsAccountDao.load(id);
	}

	@Override
	public PointsAccount get(@WebParam(name = "id")int id) {
		return pointsAccountDao.get(id);
	}

	@Override
	public List<PointsAccount> findAll() {
		return pointsAccountDao.findAll();
	}

	@Override
	public void persist(PointsAccount pointsAccount) {
		pointsAccountDao.persist(pointsAccount);
	}

	@Override
	public Integer save(PointsAccount pointsAccount) {
		return pointsAccountDao.save(pointsAccount);
	}

	@Override
	public void saveOrUpdate(PointsAccount pointsAccount) {
		pointsAccountDao.saveOrUpdate(pointsAccount);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		pointsAccountDao.delete(id);
	}

	@Override
	public void flush() {
		pointsAccountDao.flush();
	}

	@Override
	public void cleanPoints(@WebParam(name = "id")int id, @WebParam(name = "beginDate")Date beginDate, @WebParam(name = "endDate")Date endDate) {
		pointsAccountDao.cleanPoints(id, beginDate, endDate);
	}
}
