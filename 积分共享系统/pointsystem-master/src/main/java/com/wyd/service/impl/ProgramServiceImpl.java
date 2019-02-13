package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.ProgramDao;
import com.wyd.domain.Program;
import com.wyd.service.ProgramService;

@Service("programService")
@WebService(endpointInterface = "com.wyd.service.ProgramService") 
public class ProgramServiceImpl implements ProgramService{
	@Resource
	private ProgramDao programDao;

	@Override
	public List<Program> findAll() {
		return programDao.findAll();
	}

	@Override
	public Program load(@WebParam(name = "id")int id) {
		return programDao.load(id);
	}

	@Override
	public Program get(@WebParam(name = "id")int id) {
		return programDao.get(id);
	}

	@Override
	public void persist(Program program) {
		programDao.persist(program);
	}

	@Override
	public Integer save(Program program) {
		return programDao.save(program);
	}

	@Override
	public void saveOrUpdate(Program program) {
		programDao.saveOrUpdate(program);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		programDao.delete(id);
	}

	@Override
	public void flush() {
		programDao.flush();		
	}
}
