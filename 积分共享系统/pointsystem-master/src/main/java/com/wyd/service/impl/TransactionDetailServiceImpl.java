package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.TransactionDetailDao;
import com.wyd.domain.TransactionDetail;
import com.wyd.service.TransactionDetailService;

@Service("transactionDetailService")
@WebService(endpointInterface = "com.wyd.service.TransactionDetailService")
public class TransactionDetailServiceImpl implements TransactionDetailService{
	@Resource
	private TransactionDetailDao transactionDetailDao;

	@Override
	public TransactionDetail load(@WebParam(name = "id")int id) {
		return transactionDetailDao.load(id);
	}

	@Override
	public TransactionDetail get(@WebParam(name = "id")int id) {
		return transactionDetailDao.get(id);
	}

	@Override
	public List<TransactionDetail> findAll() {
		return transactionDetailDao.findAll();
	}

	@Override
	public void persist(TransactionDetail transactionDetail) {
		transactionDetailDao.persist(transactionDetail);
	}

	@Override
	public Integer save(TransactionDetail transactionDetail) {
		return transactionDetailDao.save(transactionDetail);
	}

	@Override
	public void saveOrUpdate(TransactionDetail transactionDetail) {
		transactionDetailDao.saveOrUpdate(transactionDetail);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		transactionDetailDao.delete(id);
	}

	@Override
	public void flush() {
		transactionDetailDao.flush();
	}

}
