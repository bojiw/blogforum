package com.blogforum.docking.service.mail.impl;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.MimeMessageHelper;
/**
 * html邮件发送类
 * @author Administrator
 *
 */
public class HtmlMailSend extends AbstractMailSend {
	private static final Logger logger = LoggerFactory.getLogger(HtmlMailSend.class);

	@Override
	public void send(String toMail, String subject, String text, HashMap<String, Object> extended) {

		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			//true表示需要创建一个multipart message  
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			//设置发送人邮箱
			helper.setFrom(myMail);
			//设置接收人邮箱
			helper.setTo(toMail);
			//设置主题
			helper.setSubject(subject);
			//设置内容
			helper.setText(text, true);

			javaMailSender.send(message);
		} catch (Exception e) {
			logger.error(new StringBuffer("发送邮件失败,From=").append(myMail).append(",toMail=").append(toMail)
								.append(",subject=").append(subject).append(",text=").append(text).toString(),e);
		}

	}

}
