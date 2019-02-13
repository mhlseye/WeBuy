package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.TransDetailPaymentDao;
import com.wyd.domain.TransDetailPayment;
import com.wyd.service.TransDetailPaymentService;

@Service("transDetailPaymentService")
@WebService(endpointInterface = "com.wyd.service.TransDetailPaymentService")
public class TransDetailPaymentServiceImpl implements TransDetailPaymentService{
	@Resource
	private TransDetailPaymentDao transDetailPaymentDao;

	@Override
	public TransDetailPayment load(@WebParam(name = "id")int id) {
		return transDetailPaymentDao.load(id);
	}

	@Override
	public TransDetailPayment get(@WebParam(name = "id")int id) {
		return transDetailPaymentDao.get(id);
	}

	@Override
	public List<TransDetailPayment> findAll() {
		return transDetailPaymentDao.findAll();
	}

	@Override
	public void persist(TransDetailPayment transDetailPayment) {
		transDetailPaymentDao.persist(transDetailPayment);
		
	}

	@Override
	public Integer save(TransDetailPayment transDetailPayment) {
		return transDetailPaymentDao.save(transDetailPayment);
	}

	@Override
	public void saveOrUpdate(TransDetailPayment transDetailPayment) {
		transDetailPaymentDao.saveOrUpdate(transDetailPayment);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		transDetailPaymentDao.delete(id);		
	}

	@Override
	public void flush() {
		transDetailPaymentDao.flush();		
	}
	
}
