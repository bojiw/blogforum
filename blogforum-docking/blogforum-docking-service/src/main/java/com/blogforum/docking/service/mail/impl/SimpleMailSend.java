package com.blogforum.docking.service.mail.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
/**
 * 基本邮件发送类
 * @author Administrator
 *
 */
public class SimpleMailSend extends AbstractMailSend {
	private static final Logger logger = LoggerFactory.getLogger(SimpleMailSend.class);

	@Override
	public void send(String toMail, String subject, String text, HashMap<String, Object> extended) {

		SimpleMailMessage message = new SimpleMailMessage();
		try {
			//发送人邮箱
			message.setFrom(myMail);
			//接收人邮箱
			message.setTo(toMail);
			//主题
			message.setSubject(subject);
			//内容
			message.setText(text);
			//发送邮件
			javaMailSender.send(message);
		} catch (Exception e) {
			logger.error(new StringBuffer("发送邮件失败,From=").append(myMail).append(",toMail=").append(toMail)
								.append(",subject=").append(subject).append(",text=").append(text).toString(),e);
		}

	}

}
