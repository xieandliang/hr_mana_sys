package cn.itcast.dao;

import cn.itcast.entity.Admin;

/**
 * 管理员模块dao接口
 * 
 * @author Jie.Yuan
 * 
 */
public interface IAdminDao {

	/**
	 * 保存
	 * @param admin  管理员对象
	 */
	void save(Admin admin);

	/**
	 * 根据管理员信息查询
	 * @param admin  管理员对象
	 * @return	返回查询后的结果
	 */
	Admin findByAdmin(Admin admin);

}
