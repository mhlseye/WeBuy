package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.CompanyDao;
import com.wyd.domain.Company;
import com.wyd.service.CompanyService;


@Service("companyService")
@WebService(endpointInterface = "com.wyd.service.CompanyService") 
public class CompanyServiceImpl implements CompanyService{
	
	@Resource
	private CompanyDao companyDao;

	@Override
	public Company load(@WebParam(name = "id")int id) {
		return companyDao.load(id);
	}

	@Override
	public Company get(@WebParam(name = "id")int id) {
		return companyDao.get(id);
	}

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public void persist(@WebParam(name = "entity")Company company) {
		companyDao.persist(company);
	}

	@Override
	public Integer save(@WebParam(name = "entity")Company company) {
		return companyDao.save(company);
	}

	@Override
	public void saveOrUpdate(@WebParam(name = "entity")Company company) {
		companyDao.saveOrUpdate(company);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		companyDao.delete(id);		
	}

	@Override
	public void flush() {
		companyDao.flush();
	}

}
