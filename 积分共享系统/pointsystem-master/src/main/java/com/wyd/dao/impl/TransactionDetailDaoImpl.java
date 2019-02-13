package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.TransactionDetailDao;
import com.wyd.domain.TransactionDetail;

@Repository("transactionDetailDao")
@Transactional 
public class TransactionDetailDaoImpl implements TransactionDetailDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public TransactionDetail load(int id) {
		return this.getCurrentSession().load(TransactionDetail.class, id);
	}
	
	public TransactionDetail get(int id) {
		return this.getCurrentSession().get(TransactionDetail.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TransactionDetail> findAll() {
		return this.getCurrentSession().createQuery("from TransactionDetail").setCacheable(true).list();
	}
	
	public void persist(TransactionDetail entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(TransactionDetail entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(TransactionDetail entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
