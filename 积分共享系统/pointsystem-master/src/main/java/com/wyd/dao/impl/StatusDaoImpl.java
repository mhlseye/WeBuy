package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.StatusDao;
import com.wyd.domain.Status;

@Repository("statusDao")
@Transactional 
public class StatusDaoImpl implements StatusDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Status load(int id) {
		return this.getCurrentSession().load(Status.class, id);
	}
	
	public Status get(int id) {
		return this.getCurrentSession().get(Status.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Status> findAll() {
		return this.getCurrentSession().createQuery("from Status").setCacheable(true).list();
	}
	
	public void persist(Status entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Status entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Status entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
