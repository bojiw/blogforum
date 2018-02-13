package com.blogforum.notebook.service.session;

import com.blogforum.sso.facade.model.UserVO;

/**
 * session接口
 * @author wwd
 *
 */
public interface SessionServer {
	
	/**
	 * 判断用户是否登录
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月4日
	 */
	public UserVO getUserByToken (String token);
	
	
	/**
	 * 用户退出
	 * @param token
	 * @author: wwd
	 * @time: 2018年2月7日
	 */
	public void userLoginOut(String token);

}
