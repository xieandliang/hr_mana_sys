package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Employee;

/**
 * 员工模块业务逻辑层接口
 * @author Jie.Yuan
 *
 */
 public interface IEmployeeService {
	/**
	 * 保存员工
	 * @param emp
	 */
	void save(Employee emp);

	/**
	 * 跟新员工信息
	 * @param emp
	 */
	void update(Employee emp);


	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	Employee findById(int id);

	/**
	 * 查询全部
	 * @return
	 */
	List<Employee> getAll();

	/**
	 * 根据员工名称条件查询
	 * @param employeeName
	 * @return
	 */
	List<Employee> getAll(String employeeName);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(int id);
	
	/**
	 *  删除多个员工
	 */
	void deleteMany(int[] ids);

}

