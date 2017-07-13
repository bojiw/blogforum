package com.blogforum.sso.service.loginregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.blogforum.sso.service.constant.ServiceConstant;

/**
 * 抽象邮件发送类
 * @author Administrator
 *
 */
@Service
public abstract class AbstractMailSend implements MailSend {

	/** spring 邮件服务*/
	@Autowired
	public JavaMailSender mailSender; 
	
	/**网易邮箱*/
	public String myMail = ServiceConstant.myMail;
}
