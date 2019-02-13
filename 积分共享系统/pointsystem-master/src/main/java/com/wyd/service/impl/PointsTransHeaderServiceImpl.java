package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PointsTransHeaderDao;
import com.wyd.domain.PointsTransHeader;
import com.wyd.service.PointsTransHeaderService;

@Service("pointsTransHeaderService")
@WebService(endpointInterface = "com.wyd.service.PointsTransHeaderService") 
public class PointsTransHeaderServiceImpl implements PointsTransHeaderService{
	@Resource
	private PointsTransHeaderDao pointsTransHeaderDao;

	@Override
	public PointsTransHeader load(@WebParam(name = "id")int id) {
		return pointsTransHeaderDao.load(id);
	}

	@Override
	public PointsTransHeader get(@WebParam(name = "id")int id) {
		return pointsTransHeaderDao.get(id);
	}

	@Override
	public List<PointsTransHeader> findAll() {
		return pointsTransHeaderDao.findAll();
	}

	@Override
	public void persist(PointsTransHeader pointsTransHeader) {
		pointsTransHeaderDao.persist(pointsTransHeader);
	}

	@Override
	public Integer save(PointsTransHeader pointsTransHeader) {
		return pointsTransHeaderDao.save(pointsTransHeader);
	}

	@Override
	public void saveOrUpdate(PointsTransHeader pointsTransHeader) {
		pointsTransHeaderDao.saveOrUpdate(pointsTransHeader);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		pointsTransHeaderDao.delete(id);
	}

	@Override
	public void flush() {
		pointsTransHeaderDao.flush();
	}
	
}
