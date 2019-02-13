package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.TransPaymentDao;
import com.wyd.domain.TransPayment;
import com.wyd.service.TransPaymentService;

@Service("transPaymentService")
@WebService(endpointInterface = "com.wyd.service.TransPaymentService")
public class TransPaymentServiceImpl implements TransPaymentService{
	@Resource
	private TransPaymentDao transPaymentDao;

	@Override
	public TransPayment load(@WebParam(name = "id")int id) {
		return transPaymentDao.load(id);
	}

	@Override
	public TransPayment get(@WebParam(name = "id")int id) {
		return transPaymentDao.get(id);
	}

	@Override
	public List<TransPayment> findAll() {
		return transPaymentDao.findAll();
	}

	@Override
	public void persist(TransPayment transPayment) {
		transPaymentDao.persist(transPayment);
	}

	@Override
	public Integer save(TransPayment transPayment) {
		return transPaymentDao.save(transPayment);
	}

	@Override
	public void saveOrUpdate(TransPayment transPayment) {
		transPaymentDao.saveOrUpdate(transPayment);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		transPaymentDao.delete(id);
	}

	@Override
	public void flush() {
		transPaymentDao.flush();
	}
	
}
