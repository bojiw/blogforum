package com.blogforum.sso.facade.user;

import com.blogforum.common.model.Result;
import com.blogforum.sso.facade.model.UserVO;

/**
 * 用户接口
 * @author wwd
 *
 */
public interface UserServerFacade {
	
	/**
	 * 根据userId获取用户
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月4日
	 */
	public Result<UserVO>  getUserByUserId (String userId);
	
	
}
