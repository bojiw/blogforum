package com.blogforum.sso.dao.mapper;



import com.blogforum.sso.pojo.entity.User;

public interface UserMapper extends CrudMapper<User> {
	/**
	 * 根据用户名密码获取用户
	 * @param user
	 * @return
	 * @author: wwd
	 * @time: 2017年11月8日
	 */
	public User getUserByPwdName(User user);
	
	/**
	 * 根据邮件或者手机号获取用户
	 * @param uesr
	 * @return
	 * @author: wwd
	 * @time: 2017年11月8日
	 */
	public User getUserByEmailORIphone(User uesr);
	
	/**
	 * 根据用户名获取用户
	 * @param user
	 * @return
	 * @author: wwd
	 * @time: 2017年11月8日
	 */
	public User getUserByName(User user);
}
