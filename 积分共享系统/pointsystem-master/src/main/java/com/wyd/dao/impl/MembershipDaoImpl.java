package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.MembershipDao;
import com.wyd.domain.Membership;
import com.wyd.domain.PointsAccount;

@Repository("membershipDao")
@Transactional 
public class MembershipDaoImpl implements MembershipDao{
	
	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Membership load(int id) {
		return this.getCurrentSession().load(Membership.class, id);
	}
	
	public Membership get(int id) {
		return this.getCurrentSession().get(Membership.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Membership> findAll() {
		return this.getCurrentSession().createQuery("from Membership").setCacheable(true).list();
	}
	
	public void persist(Membership entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Membership entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Membership entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

	@Override
	public Integer getPointsTotal(int membershipId) {
		return (Integer) this.getCurrentSession()
				.createQuery("select p.pointsTotal from PointsAccount p inner join p.membership m where p.membership.membershipId = :membershipId")
				.setParameter("membershipId", membershipId)
				.list().get(0);
	}
	
	@Override
	public Integer setPointsTotal(int membershipId,int pointsTotal) {
		  return (Integer)this.getCurrentSession()
				.createQuery("update PointsAccount p set p.pointsTotal = :pointsTotal where p.membership.membershipId = :membershipId")
				.setParameter("membershipId", membershipId)
				.setParameter("pointsTotal", pointsTotal).executeUpdate();
	}
	
	public Membership getMembershipByCellPhone(String cellPhone) {
		return (Membership) this.getCurrentSession().createQuery("from Membership m where m.cellPhone = :cellPhone")
				.setParameter("cellPhone", cellPhone)
				.list().get(0);
	}
	
	public PointsAccount getPointsAccountByMembershipId(int membershipId) {
		return (PointsAccount) this.getCurrentSession()
				.createQuery("select p from PointsAccount p inner join p.membership m where p.membership.membershipId = :membershipId")
				.setParameter("membershipId", membershipId)
				.list().get(0);
	}
}
