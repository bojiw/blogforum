package com.blogforum.sso.service.loginregistration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.common.enums.SSOBizError;
import com.blogforum.sso.common.exception.SSOBusinessException;
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
		userMapper.save(user);
		return blogforumResult.ok();
	}

	@Override
	protected void checkSmsValue(User user, String verificationcode) {
		super.checkSmsValue(user, verificationcode);
		//效验验证码是否正确
		String code = redisClient.get(REGISTER_KEY + ":" + user.getIphone());
		if (!StringUtils.equals(code, verificationcode)) {
			throw new SSOBusinessException(SSOBizError.VECODE_ERROR);
		}
	}
	
}
