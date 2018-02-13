package com.blogforum.sso.service.loginregistration;

import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.pojo.entity.User;
@Component
public class SmsRegister extends AbstractLoginRegister {

	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		User user = context.getUser();
		//效验数据
		this.checkSmsValue(user, context.getVerificationCode());
		//填充用户并且设置cookie和session
		buildUserAndSessionCookie(user, context.getHttpServletResponse());
		//保存用户
		initeUser.createUser(user);
		return blogforumResult.ok(noteServerUrl);
	}

	@Override
	protected void checkSmsValue(User user, String verificationcode) {
		super.checkSmsValue(user, verificationcode);
		super.checkRegisterKey(user.getIphone(),verificationcode);
	}
	
}
