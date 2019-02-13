package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PointsDepositTransDetailDao;
import com.wyd.domain.PointsDepositTransDetail;

@Repository("pointsDepositTransDetailDao")
@Transactional 
public class PointsDepositTransDetailDaoImpl implements PointsDepositTransDetailDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PointsDepositTransDetail load(int id) {
		return this.getCurrentSession().load(PointsDepositTransDetail.class, id);
	}
	
	public PointsDepositTransDetail get(int id) {
		return this.getCurrentSession().get(PointsDepositTransDetail.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointsDepositTransDetail> findAll() {
		return this.getCurrentSession().createQuery("from PointsDepositTransDetail").setCacheable(true).list();
	}
	
	public void persist(PointsDepositTransDetail entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PointsDepositTransDetail entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PointsDepositTransDetail entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
