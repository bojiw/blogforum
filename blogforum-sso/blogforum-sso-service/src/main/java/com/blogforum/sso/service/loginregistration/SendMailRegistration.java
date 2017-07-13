package com.blogforum.sso.service.loginregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.common.utils.MathCalculationUtil;
import com.blogforum.sso.dao.redis.RedisClient;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.constant.ServiceConstant;

@Component
@Transactional
public class SendMailRegistration implements LoginRegistration {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/** redis客户端 */
	@Autowired
	private RedisClient		redisClient;

	/** 标准邮件发送类 */
	@Autowired
	private SimpleMailSend	simpleMailSend;

	@Override
	public blogforumResult execute(User user) {
		//发送邮件  传入接收邮件人 邮件主题  邮件内容
		simpleMailSend.send(user.getEmail(), ServiceConstant.subject, buildMailInfo(user));
		return blogforumResult.ok();

	}

	/**
	 * 拼装验证码信息
	 * 
	 * @param user
	 * @return
	 */
	private String buildMailInfo(User user) {
		StringBuffer mailInfo = new StringBuffer();
		//四位验证码
		int verificationCode = MathCalculationUtil.getFourRandom();
		//把验证码设置到redis中并30分钟后过期
		redisClient.setExpire(user.getEmail(), verificationCode, 1800);
		mailInfo.append("注册码为:  ").append(verificationCode).append("。");
		logger.info("邮箱为:" + user.getEmail() + ",发送邮件内容：" + mailInfo.toString());
		return mailInfo.toString();

	}

}
