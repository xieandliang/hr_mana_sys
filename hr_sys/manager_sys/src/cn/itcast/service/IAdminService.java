package cn.itcast.service;

import cn.itcast.entity.Admin;

/**
 * 管理员业务逻辑层接口
 * 
 * @author Jie.Yuan
 * 
 */
 public interface IAdminService {

	/**
	 * 注册
	 * @param admin
	 */
	void register(Admin admin);

	/**
	 * 登陆
	 * @param admin
	 * @return
	 */
	Admin login(Admin admin);

}
