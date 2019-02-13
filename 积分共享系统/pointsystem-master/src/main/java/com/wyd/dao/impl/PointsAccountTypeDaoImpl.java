package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PointsAccountTypeDao;
import com.wyd.domain.PointsAccountType;

@Repository("pointsAccountTypeDao")
@Transactional 
public class PointsAccountTypeDaoImpl implements PointsAccountTypeDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PointsAccountType load(int id) {
		return this.getCurrentSession().load(PointsAccountType.class, id);
	}
	
	public PointsAccountType get(int id) {
		return this.getCurrentSession().get(PointsAccountType.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointsAccountType> findAll() {
		return this.getCurrentSession().createQuery("from PointsAccountType").setCacheable(true).list();
	}
	
	public void persist(PointsAccountType entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PointsAccountType entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PointsAccountType entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

}
