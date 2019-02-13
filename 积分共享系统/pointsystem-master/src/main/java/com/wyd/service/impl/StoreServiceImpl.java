package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.StoreDao;
import com.wyd.domain.Store;
import com.wyd.service.StoreService;

@Service("storeService")
@WebService(endpointInterface = "com.wyd.service.StoreService") 
public class StoreServiceImpl implements StoreService{
	@Resource
	private StoreDao storeDao;

	@WebMethod
	public Store load(@WebParam(name = "id")int id) {
		return storeDao.load(id);
	}

	@WebMethod
	public Store get(@WebParam(name = "id")int id) {
		return storeDao.get(id);
	}

	public List<Store> findAll() {
		return storeDao.findAll();
	}

	public void persist(Store store) {
		storeDao.persist(store);		
	}

	public Integer save(Store store) {
		int status = 1;
		storeDao.save(store);
		return status;
	}

	public void saveOrUpdate(Store store) {
		storeDao.saveOrUpdate(store);		
	}

	public void delete(@WebParam(name = "id")int id) {
		storeDao.delete(id);		
	}

	public void flush() {
		storeDao.flush();		
	}
}
