package com.wyd.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.PointsAccountDao;
import com.wyd.domain.PointsAccount;

@Repository("pointsAccountDao")
@Transactional 
public class PointsAccountDaoImpl implements PointsAccountDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public PointsAccount load(int id) {
		return this.getCurrentSession().load(PointsAccount.class, id);
	}
	
	public PointsAccount get(int id) {
		return this.getCurrentSession().get(PointsAccount.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<PointsAccount> findAll() {
		return this.getCurrentSession().createQuery("from PointsAccount").setCacheable(true).list();
	}
	
	public void persist(PointsAccount entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(PointsAccount entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(PointsAccount entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

	@Override
	public void cleanPoints(int id,Date beginDate, Date endDate) {
		getCurrentSession()
		.createQuery("delete from PointsAccount where (LAST_UPDATED_DTTM between :beginDate and :endDate) and id = :id")
		.setParameter("beginDate", beginDate)
		.setParameter("endDate", endDate)
		.setParameter("id", id);
	}

}
