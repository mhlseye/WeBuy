package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PointsDepositTransDetailDao;
import com.wyd.domain.PointsDepositTransDetail;
import com.wyd.service.PointsDepositTransDetailService;

@Service("pointsDepositTransDetailService")
@WebService(endpointInterface = "com.wyd.service.PointsDepositTransDetailService") 
public class PointsDepositTransDetailServiceImpl implements PointsDepositTransDetailService{
	@Resource
	private PointsDepositTransDetailDao pointsDepositTransDetailDao;

	@Override
	public PointsDepositTransDetail load(@WebParam(name = "id")int id) {
		return pointsDepositTransDetailDao.load(id);
	}

	@Override
	public PointsDepositTransDetail get(@WebParam(name = "id")int id) {
		return pointsDepositTransDetailDao.get(id);
	}

	@Override
	public List<PointsDepositTransDetail> findAll() {
		return pointsDepositTransDetailDao.findAll();
	}

	@Override
	public void persist(PointsDepositTransDetail pointsDepositTransDetail) {
		pointsDepositTransDetailDao.persist(pointsDepositTransDetail);
	}

	@Override
	public Integer save(PointsDepositTransDetail pointsDepositTransDetail) {
		return pointsDepositTransDetailDao.save(pointsDepositTransDetail);
	}

	@Override
	public void saveOrUpdate(PointsDepositTransDetail pointsDepositTransDetail) {
		pointsDepositTransDetailDao.saveOrUpdate(pointsDepositTransDetail);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		pointsDepositTransDetailDao.delete(id);
	}

	@Override
	public void flush() {
		pointsDepositTransDetailDao.flush();
	}
}
