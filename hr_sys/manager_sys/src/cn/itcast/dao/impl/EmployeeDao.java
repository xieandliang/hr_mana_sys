package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;

 public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

	@SuppressWarnings("unchecked")
	//@Override
	public List<Employee> getAll(String employeeName) {
		return getSessionFactory().getCurrentSession()//
			.createQuery("from Employee where empName like ?")//
			.setParameter(0, "%" +employeeName + "%")//
			.list();
	}
	
	@Override
	public Employee findById(int id) {
		String hql = "from Employee e left join fetch e.dept where e.id=?";			
		return (Employee) getSessionFactory()
			.getCurrentSession()
			.createQuery(hql)
			.setParameter(0, id)
			.uniqueResult();
	}

}
