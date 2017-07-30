package com.blogforum.manager.service.adminuser;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;

/**
 * 对管理员用户的操作接口
 * 
 * @author wwd
 *
 */
public interface AdminUserService {
	/**
	 * 创建管理员用户
	 * 
	 * @param adminUser
	 * @author wwd
	 * @date 2017年2月25日下午2:58:53
	 * @version V1.0
	 */
	public blogforumResult insert(AdminUser adminUser);

	
	/**
	 * 通过用户名密码查询用户
	 * 
	 * @param adminUser
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByUserPwd(AdminUser adminUser);

	
	/**
	 * 通过ID查询用户
	 * 
	 * @param adminUser_id
	 * @return AdminUser
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByID(String adminUser_id);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 * @return AdminUser
	 * @author wwd
	 * @date 2017年3月10日下午9:31:22
	 * @version V1.0
	 */
	public AdminUser getByUserName(String username);
}
