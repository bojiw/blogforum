package com.blogforum.sso.service.loginregistration;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.constant.ServiceConstant;
import com.blogforum.sso.service.mail.MailSend;

@Component
public class SendMailRegister extends AbstractLoginRegister {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/** 标准邮件发送类 */
	@Autowired
	private MailSend	simpleMailSend;
	
	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		User user = context.getUser();
		//效验参数
		checkMailValue(user,"0000");
		//获取验证码
		String verificationCode = getVerificationCodeAndSetExRedis(user.getEmail());
		//发送邮件  传入接收邮件人 邮件主题  邮件内容
		simpleMailSend.send(user.getEmail(), ServiceConstant.subject, buildMailInfo(verificationCode),null);
		return blogforumResult.ok();

	}

	/**
	 * 拼装邮件信息
	 * 
	 * @param user
	 * @return
	 */
	private String buildMailInfo(String verificationCode) {
		StringBuffer mailInfo = new StringBuffer();
		mailInfo.append("注册码为:  ").append(verificationCode).append("。");
		logger.info(MessageFormat.format("成功发送邮件，邮箱为:{0},邮件内容为{1}", verificationCode,mailInfo.toString()));
		return mailInfo.toString();

	}

}
