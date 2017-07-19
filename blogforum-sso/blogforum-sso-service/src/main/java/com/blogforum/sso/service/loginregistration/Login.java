package com.blogforum.sso.service.loginregistration;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.blogforum.common.enums.BizError;
import com.blogforum.common.tools.CookieUtils;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.common.utils.MD5SaltUtils;
import com.blogforum.sso.common.utils.Preconditions;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.constant.ServiceConstant;

@Component
public class Login extends AbstractLoginRegister {

	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		//获取token 判断用户是否已经登录
		String token = CookieUtils.getCookie(context.getHttpServletRequest(), ServiceConstant.cookieToken);
		if (StringUtils.isNotBlank(token)) {
			String userJSON = redisClient.get(token);
			if (StringUtils.isNotBlank(userJSON)) {
				redisClient.expire(token, SESSION_TIME);
				return blogforumResult.ok();
			}
		}
		User user = context.getUser();
		super.checkUserPwd(user);
		//判断用户名密码是否正确 正确则设置session和cookie
		isUserAndsetSession(user, context.getHttpServletResponse());
		return blogforumResult.ok();
	}
	
	
	/**
	 * 判断用户名密码是否正确
	 * 
	 * @author: Administrator
	 * @time: 2017年7月16日
	 */
	private void isUserAndsetSession(User user,HttpServletResponse httpServletResponse){
		//获取数据库中用户名对应的salt
		User saltUser = userMapper.getUserByName(user);
		Preconditions.checkNotNull(saltUser, BizError.NO_USER);
		//使用salt对用户上传的密码进行加密再重新设置
		String encodePWD = MD5SaltUtils.encode(user.getPassword(), saltUser.getSalt());
		user.setPassword(encodePWD);
		//通过用户名密码获取用户
		User newUser = userMapper.getUserByPwdName(user);
		Preconditions.checkNotNull(newUser, BizError.FAIL_USERPWD);
		//用户存在则保存到session和cookie中
		SessionCookie(newUser, httpServletResponse);
		
	}
	
	
	

}
