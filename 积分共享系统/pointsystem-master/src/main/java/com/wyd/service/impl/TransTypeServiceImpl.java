package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.TransTypeDao;
import com.wyd.domain.TransType;
import com.wyd.service.TransTypeService;

@Service("transTypeService")
@WebService(endpointInterface = "com.wyd.service.TransTypeService")
public class TransTypeServiceImpl implements TransTypeService{
	@Resource
	private TransTypeDao transTypeDao;

	@Override
	public TransType load(@WebParam(name = "id")int id) {
		return transTypeDao.load(id);
	}

	@Override
	public TransType get(@WebParam(name = "id")int id) {
		return transTypeDao.get(id);
	}

	@Override
	public List<TransType> findAll() {
		return transTypeDao.findAll();
	}

	@Override
	public void persist(TransType transType) {
		transTypeDao.persist(transType);
		
	}

	@Override
	public Integer save(TransType transType) {
		return transTypeDao.save(transType);
	}

	@Override
	public void saveOrUpdate(TransType transType) {
		transTypeDao.saveOrUpdate(transType);
		
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		transTypeDao.delete(id);
	}

	@Override
	public void flush() {
		transTypeDao.flush();
	}
	
}
