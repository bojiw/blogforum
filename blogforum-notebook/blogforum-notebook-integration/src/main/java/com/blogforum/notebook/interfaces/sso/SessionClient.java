package com.blogforum.notebook.interfaces.sso;

import com.blogforum.sso.facade.model.UserVO;

public interface SessionClient {

	
	/**
	 * 判断用户是否登录
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月4日
	 */
	public Boolean  isLogin (String token);
	
	/**
	 * 根据token获取session中的用户并更新用户的过期时间
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月14日
	 */
	public UserVO getUserByToken(String token);
	
	/**
	 * 用户退出登录
	 * @param token
	 * @author: wwd
	 * @time: 2018年2月7日
	 */
	public Boolean userLoginOut(String token);
}
