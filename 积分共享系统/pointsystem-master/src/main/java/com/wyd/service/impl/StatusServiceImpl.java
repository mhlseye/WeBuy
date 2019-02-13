package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.StatusDao;
import com.wyd.domain.Status;
import com.wyd.service.StatusService;

@Service("statusService")
@WebService(endpointInterface = "com.wyd.service.StatusService") 
public class StatusServiceImpl implements StatusService{
	
	@Resource
	private StatusDao statusDao;

	@Override
	@WebMethod
	public Status load(@WebParam(name = "id")int id) {
		return statusDao.load(id);
	}

	@Override
	@WebMethod
	public Status get(@WebParam(name = "id")int id) {
		return statusDao.get(id);
	}

	@Override
	public List<Status> findAll() {
		return statusDao.findAll();
	}

	@Override
	public void persist(Status status) {
		statusDao.persist(status);		
	}

	@Override
	public Integer save(Status status) {
		return statusDao.save(status);
	}

	@Override
	public void saveOrUpdate(Status status) {
		statusDao.saveOrUpdate(status);		
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		statusDao.delete(id);		
	}

	@Override
	public void flush() {
		statusDao.flush();		
	}
}
