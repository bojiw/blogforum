package com.blogforum.service.adminuser;

import com.blogforum.manager.pojo.entity.Role;

public interface RoleService {
	
	/**
	 * 插入角色
	 * 
	 * @param role
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午11:52:27
	 * @version V1.0
	 */
	public int insert(RoleService role);

	/**
	 * 通过ID查询角色
	 * 
	 * @param role_id
	 * @return
	 * @author wwd
	 * @date 2017年3月10日下午11:53:45
	 * @version V1.0
	 */
	public Role getByID(int role_id);
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 * @author wwd
	 * @date 2017年3月13日下午10:39:21
	 * @version V1.0
	 */
	public int updateRole(Role role);

}
