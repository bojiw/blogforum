package com.blogforum.sso.service.loginregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.sso.dao.redis.RedisClick;
import com.blogforum.sso.pojo.entity.User;

@Component
public class SendMailRegistration implements LoginRegistration {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/**redis客户端*/
	@Autowired
	private RedisClick redisClick;
	
	@Override
	public void execute(User user) throws Exception {
		//邮件发送类
		MailSend mailSend = new MailSend();
		//设置接收邮件人
		mailSend.setToMail(user.getEmail());
		//设置邮件内容
		mailSend.setText(buildMailInfo(user));
		//发送邮件
		mailSend.send();

	}

	/**
	 * 拼装验证码信息
	 * @param user
	 * @return
	 */
	private String buildMailInfo(User user) throws Exception {
		StringBuffer mailInfo = new StringBuffer();
		//验证码
		int verificationCode =  (int)(Math.random() * 10000);
		//注册用户邮箱和验证码保存到redis中
		redisClick.setObject(user.getEmail(), verificationCode);
		//设置30分钟过期
		redisClick.expire(user.getEmail(), 1800);
		mailInfo.append("注册码为:/t").append(verificationCode).append("。s");
		logger.info("邮箱为:" + user.getEmail() + ",发送邮件内容：" + mailInfo.toString());
		return mailInfo.toString();

	}

}
