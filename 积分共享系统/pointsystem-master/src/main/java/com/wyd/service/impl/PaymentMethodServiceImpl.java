package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.PaymentMethodDao;
import com.wyd.domain.PaymentMethod;
import com.wyd.service.PaymentMethodService;

@Service("paymentMethodService")
@WebService(endpointInterface = "com.wyd.service.PaymentMethodService") 
public class PaymentMethodServiceImpl implements PaymentMethodService{
	@Resource
	private PaymentMethodDao paymentMethodDao;

	@Override
	public PaymentMethod load(@WebParam(name = "id")int id) {
		return paymentMethodDao.load(id);
	}

	@Override
	public PaymentMethod get(@WebParam(name = "id")int id) {
		return paymentMethodDao.get(id);
	}

	@Override
	public List<PaymentMethod> findAll() {
		return paymentMethodDao.findAll();
	}

	@Override
	public void persist(PaymentMethod paymentMethod) {
		paymentMethodDao.persist(paymentMethod);
	}

	@Override
	public Integer save(PaymentMethod paymentMethod) {
		return paymentMethodDao.save(paymentMethod);
	}

	@Override
	public void saveOrUpdate(PaymentMethod paymentMethod) {
		paymentMethodDao.saveOrUpdate(paymentMethod);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		paymentMethodDao.delete(id);
	}

	@Override
	public void flush() {
		paymentMethodDao.flush();
	}

}
