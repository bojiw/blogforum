package com.blogforum.docking.service.mail.impl;

import java.io.File;
import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AttachmentsMailSend extends AbstractMailSend {
	private static final Logger logger = LoggerFactory.getLogger(AttachmentsMailSend.class);

	@Override
	public void send(String toMail, String subject, String text, HashMap<String, Object> extended) {
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			//true表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(myMail);
			helper.setTo(toMail);
			helper.setSubject(subject);
			helper.setText(text, true);
			String file = (String) extended.get("file");
			FileSystemResource fileresource = new FileSystemResource(new File(file));
			String fileName = file.substring(file.lastIndexOf(File.separator));
	        helper.addAttachment(fileName, fileresource);
	        
	        javaMailSender.send(message);
			logger.info("带附件的邮件已经发送。");
		} catch (Exception e) {
			logger.error(new StringBuffer("发送邮件失败,From=").append(myMail).append(",toMail=").append(toMail)
								.append(",subject=").append(subject).append(",text=").append(text).toString(),e);
		}

	}

}
