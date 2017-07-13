package com.blogforum.sso.service.loginregistration;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.blogforum.sso.common.exception.SSOBusinessException;

/**
 * html邮件发送类
 * @author Administrator
 *
 */
@Service
public class HtmlMailSend extends AbstractMailSend {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void send(String toMail, String subject, String text) {
		MimeMessage message = mailSender.createMimeMessage();  
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
  
            mailSender.send(message);  
            logger.info("html邮件已经发送。");  
        } catch (Exception e) {  
        	throw new SSOBusinessException("发送邮件失败 请重试！！！");
        }  

	}

}
