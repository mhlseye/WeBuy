package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PointsTransHeaderDao;
import com.wyd.domain.PointsTransHeader;

@Repository("pointsTransHeaderDao")
@Transactional 
public class PointsTransHeaderDaoImpl implements PointsTransHeaderDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PointsTransHeader load(int id) {
		return this.getCurrentSession().load(PointsTransHeader.class, id);
	}
	
	public PointsTransHeader get(int id) {
		return this.getCurrentSession().get(PointsTransHeader.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointsTransHeader> findAll() {
		return this.getCurrentSession().createQuery("from PointsTransHeader").setCacheable(true).list();
	}
	
	public void persist(PointsTransHeader entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PointsTransHeader entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PointsTransHeader entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
