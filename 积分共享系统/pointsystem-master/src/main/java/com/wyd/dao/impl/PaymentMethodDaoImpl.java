package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PaymentMethodDao;
import com.wyd.domain.PaymentMethod;

@Repository("paymentMethodDao")
@Transactional 
public class PaymentMethodDaoImpl implements PaymentMethodDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PaymentMethod load(int id) {
		return this.getCurrentSession().load(PaymentMethod.class, id);
	}
	
	public PaymentMethod get(int id) {
		return this.getCurrentSession().get(PaymentMethod.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PaymentMethod> findAll() {
		return this.getCurrentSession().createQuery("from PaymentMethod").setCacheable(true).list();
	}
	
	public void persist(PaymentMethod entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PaymentMethod entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PaymentMethod entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
