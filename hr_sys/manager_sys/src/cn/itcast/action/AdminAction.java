package cn.itcast.action;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 管理员登陆注册模块
 * 1. 登陆
 * @author Jie.Yuan
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

 	// 封装请求数据
	private Admin admin = new Admin();
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	
//	@Override
	public Admin getModel() {
		return admin;
	}
	
	// 调用Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * 登陆
	 */
	public String login(){
		// 登陆验证
		Admin adminInfo = adminService.login(admin);
		// 验证
		if (adminInfo == null){
			// 登陆失败
			return "loginFaild";
		} else {
			// 登陆成功, 保存数据到session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
