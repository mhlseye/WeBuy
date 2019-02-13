package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.StoreDao;
import com.wyd.domain.Store;

@Repository("storeDao")
@Transactional 
public class StoreDaoImpl implements StoreDao{
	
	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

	public Store load(int id) {
		return this.getCurrentSession().load(Store.class, id);
	}
	
	public Store get(int id) {
		return this.getCurrentSession().get(Store.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Store> findAll() {
		return this.getCurrentSession().createQuery("from Store").setCacheable(true).list();
	}
	
	public void persist(Store entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Store entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Store entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

}
