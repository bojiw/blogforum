package com.blogforum.sso.service.loginregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.blogforum.common.tools.UUIDCreateUtile;
import com.blogforum.sso.dao.redis.RedisClick;
import com.blogforum.sso.pojo.entity.User;

public class SendMailRegistration implements LoginRegistration {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/**redis客户端*/
	@Autowired
	private RedisClick redisClick;
	
	/** 邮件发送*/
	@Autowired
	private MailSend		mailSend;

	/**服务器地址*/
	@Value(value = "serviceUrl")
	private String			serviceUrl;

	@Override
	public void execute(User user) throws Exception {
		//设置接收邮件人
		mailSend.setToMail(user.getEmail());
		//设置邮件内容
		mailSend.setText(buildMailInfo(user));
		//发送邮件
		mailSend.send();

	}

	private String buildMailInfo(User user) throws Exception {
		StringBuffer mailInfo = new StringBuffer();
		String userId = UUIDCreateUtile.getUUID();
		//注册用户保存到redis中
		redisClick.setObject(userId, user);
		//设置30分钟过期
		redisClick.expire(userId, 1800);
		mailInfo.append("请点击下面链接完成注册:/t").append(serviceUrl).append("/").append("loginregistration").append(userId);
		logger.info("发送邮件内容：" + mailInfo.toString());
		return mailInfo.toString();

	}

}
