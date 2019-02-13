package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.ProgramDao;
import com.wyd.domain.Program;

@Repository("programDao")
@Transactional 
public class ProgramDaoImpl implements ProgramDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Program load(int id) {
		return this.getCurrentSession().load(Program.class, id);
	}
	
	public Program get(int id) {
		return this.getCurrentSession().get(Program.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Program> findAll() {
		return this.getCurrentSession().createQuery("from Program").setCacheable(true).list();
	}
	
	public void persist(Program entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Program entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Program entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
