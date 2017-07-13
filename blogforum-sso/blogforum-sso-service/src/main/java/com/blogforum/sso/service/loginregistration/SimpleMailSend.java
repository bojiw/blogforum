package com.blogforum.sso.service.loginregistration;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.blogforum.sso.common.exception.SSOBusinessException;

/**
 * 基本邮件发送类
 * @author Administrator
 *
 */
@Service
public class SimpleMailSend extends AbstractMailSend {
	
	/**
	 * 发送邮件
	 */
	public void send(String toMail,String subject,String text){
		
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
            mailSender.send(message);  
		} catch (Exception e) {
        	throw new SSOBusinessException("发送邮件失败 请重试！！！");
		}
	}

}
