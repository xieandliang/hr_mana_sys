package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IDeptDao;
import cn.itcast.entity.Dept;
import cn.itcast.service.IDeptService;

public class DeptService implements IDeptService {
	
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	 //@Override
	public Dept findById(int id) {
		return deptDao.findById(id);
	}

	//@Override
	public List<Dept> getAll() {
		return deptDao.getAll();
	}

}
