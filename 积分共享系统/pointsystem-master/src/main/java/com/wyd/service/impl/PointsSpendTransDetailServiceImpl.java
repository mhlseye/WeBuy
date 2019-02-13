package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PointsSpendTransDetailDao;
import com.wyd.domain.PointsSpendTransDetail;
import com.wyd.service.PointsSpendTransDetailService;

@Service("pointsSpendTransDetailService")
@WebService(endpointInterface = "com.wyd.service.PointsSpendTransDetailService") 
public class PointsSpendTransDetailServiceImpl implements PointsSpendTransDetailService{
	@Resource
	private PointsSpendTransDetailDao pointsSpendTransDetailDao;

	@Override
	public PointsSpendTransDetail load(@WebParam(name = "id")int id) {
		return pointsSpendTransDetailDao.load(id);
	}

	@Override
	public PointsSpendTransDetail get(@WebParam(name = "id")int id) {
		return pointsSpendTransDetailDao.get(id);
	}

	@Override
	public List<PointsSpendTransDetail> findAll() {
		return pointsSpendTransDetailDao.findAll();
	}

	@Override
	public void persist(PointsSpendTransDetail pointsSpendTransDetail) {
		pointsSpendTransDetailDao.persist(pointsSpendTransDetail);
	}

	@Override
	public Integer save(PointsSpendTransDetail pointsSpendTransDetail) {
		return pointsSpendTransDetailDao.save(pointsSpendTransDetail);
	}

	@Override
	public void saveOrUpdate(PointsSpendTransDetail pointsSpendTransDetail) {
		pointsSpendTransDetailDao.saveOrUpdate(pointsSpendTransDetail);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		pointsSpendTransDetailDao.delete(id);
	}

	@Override
	public void flush() {
		pointsSpendTransDetailDao.flush();
	}
}
