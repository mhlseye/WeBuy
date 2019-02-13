package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PointsSpendTransDetailDao;
import com.wyd.domain.PointsSpendTransDetail;

@Repository("pointsSpendTransDetailDao")
@Transactional 
public class PointsSpendTransDetailDaoImpl implements PointsSpendTransDetailDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PointsSpendTransDetail load(int id) {
		return this.getCurrentSession().load(PointsSpendTransDetail.class, id);
	}
	
	public PointsSpendTransDetail get(int id) {
		return this.getCurrentSession().get(PointsSpendTransDetail.class, id);
	}
	
	public List<PointsSpendTransDetail> findAll() {
		return null;
	}
	
	public void persist(PointsSpendTransDetail entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PointsSpendTransDetail entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PointsSpendTransDetail entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
