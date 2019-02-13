package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PointsAccountTypeDao;
import com.wyd.domain.PointsAccountType;
import com.wyd.service.PointsAccountTypeService;

@Service("pointsAccountTypeService")
@WebService(endpointInterface = "com.wyd.service.PointsAccountTypeService") 
public class PointsAccountTypeServiceImpl implements PointsAccountTypeService{
	@Resource
	private PointsAccountTypeDao pointsAccountTypeDao;

	@Override
	public PointsAccountType load(@WebParam(name = "id")int id) {
		return pointsAccountTypeDao.load(id);
	}

	@Override
	public PointsAccountType get(@WebParam(name = "id")int id) {
		return pointsAccountTypeDao.get(id);
	}

	@Override
	public List<PointsAccountType> findAll() {
		return pointsAccountTypeDao.findAll();
	}

	@Override
	public void persist(PointsAccountType pointsAccountType) {
		pointsAccountTypeDao.persist(pointsAccountType);
	}

	@Override
	public Integer save(PointsAccountType pointsAccountType) {
		return pointsAccountTypeDao.save(pointsAccountType);
	}

	@Override
	public void saveOrUpdate(PointsAccountType pointsAccountType) {
		pointsAccountTypeDao.saveOrUpdate(pointsAccountType);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		pointsAccountTypeDao.delete(id);
	}

	@Override
	public void flush() {
		pointsAccountTypeDao.flush();
	}
}
