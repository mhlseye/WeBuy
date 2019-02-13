package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.TransTypeDao;
import com.wyd.domain.TransType;

@Repository("transTypeDao")
@Transactional 
public class TransTypeDaoImpl implements TransTypeDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public TransType load(int id) {
		return this.getCurrentSession().load(TransType.class, id);
	}
	
	public TransType get(int id) {
		return this.getCurrentSession().get(TransType.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TransType> findAll() {
		return this.getCurrentSession().createQuery("from TransType").setCacheable(true).list();
	}
	
	public void persist(TransType entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(TransType entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(TransType entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
