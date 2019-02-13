package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.TransDetailPaymentDao;
import com.wyd.domain.TransDetailPayment;

@Repository("transDetailPaymentDao")
@Transactional 
public class TransDetailPaymentDaoImpl implements TransDetailPaymentDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public TransDetailPayment load(int id) {
		return this.getCurrentSession().load(TransDetailPayment.class, id);
	}
	
	public TransDetailPayment get(int id) {
		return this.getCurrentSession().get(TransDetailPayment.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TransDetailPayment> findAll() {
		return this.getCurrentSession().createQuery("from TransDetailPayment").setCacheable(true).list();
	}
	
	public void persist(TransDetailPayment entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(TransDetailPayment entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(TransDetailPayment entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
