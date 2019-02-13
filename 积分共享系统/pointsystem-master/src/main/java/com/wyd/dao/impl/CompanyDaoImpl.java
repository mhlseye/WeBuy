package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.CompanyDao;
import com.wyd.domain.Company;

@Repository("companyDao")
@Transactional 
public class CompanyDaoImpl implements CompanyDao{
	
	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Company load(int id) {
		return this.getCurrentSession().load(Company.class, id);
	}
	
	public Company get(int id) {
		return this.getCurrentSession().get(Company.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> findAll() {
		return this.getCurrentSession().createQuery("from Company").setCacheable(true).list();
	}
	
	public void persist(Company entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Company entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Company entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

}
