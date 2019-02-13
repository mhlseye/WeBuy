package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.TransPaymentDao;
import com.wyd.domain.TransPayment;

@Repository("transPaymentDao")
@Transactional 
public class TransPaymentDaoImpl implements TransPaymentDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public TransPayment load(int id) {
		return this.getCurrentSession().load(TransPayment.class, id);
	}
	
	public TransPayment get(int id) {
		return this.getCurrentSession().get(TransPayment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TransPayment> findAll() {
		return this.getCurrentSession().createQuery("from TransPayment").setCacheable(true).list();
	}
	
	public void persist(TransPayment entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(TransPayment entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(TransPayment entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
