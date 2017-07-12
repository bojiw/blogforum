package com.blogforum.sso.service.loginregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.dao.redis.RedisClient;
import com.blogforum.sso.pojo.entity.User;

@Component
@Transactional
public class SendMailRegistration implements LoginRegistration {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/**redis客户端*/
	@Autowired
	private RedisClient redisClient;
	
	@Override
	public blogforumResult execute(User user){
		//邮件发送类
		MailSend mailSend = new MailSend();
		//设置接收邮件人
		mailSend.setToMail(user.getEmail());
		//设置邮件内容
		mailSend.setText(buildMailInfo(user));
		//发送邮件
		mailSend.send();
		
		return blogforumResult.ok();

	}

	/**
	 * 拼装验证码信息
	 * @param user
	 * @return
	 */
	private String buildMailInfo(User user){
		StringBuffer mailInfo = new StringBuffer();
		//四位验证码
		int verificationCode =  (int)(Math.random()*(9000)+1000);
		//把验证码设置到redis中并30分钟后过期
		redisClient.setExpire(user.getEmail(), verificationCode, 1800);
		mailInfo.append("注册码为:  ").append(verificationCode).append("。");
		logger.info("邮箱为:" + user.getEmail() + ",发送邮件内容：" + mailInfo.toString());
		return mailInfo.toString();

	}

}
