package com.blogforum.docking.service.mail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.blogforum.docking.service.mail.MailSend;
@Service
public abstract class AbstractMailSend implements MailSend {
	
	@Autowired
	protected JavaMailSender javaMailSender;
	
	/**网易邮箱*/
	@Value("${mail.myMail}")
	protected String myMail;

}
