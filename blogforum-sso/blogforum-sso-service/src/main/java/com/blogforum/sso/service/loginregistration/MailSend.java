package com.blogforum.sso.service.loginregistration;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.blogforum.sso.common.exception.SSOBusinessException;
import com.blogforum.sso.common.utils.SpringUtil;
import com.blogforum.sso.service.constant.ServiceConstant;

/**
 * 邮件发送类
 * @author Administrator
 *
 */
public class MailSend {
	
	/** spring 邮件服务*/
    private JavaMailSender mailSender; 
	
	/**网易邮箱*/
	public String myMail;
	
	/**邮件主题*/
	public String subject;
	
	/**收件人邮箱*/
	public String toMail;
	
	/**邮件内容*/
	public String text;
	
	public MailSend() {
		this.myMail = ServiceConstant.myMail;
		this.subject = ServiceConstant.subject;
		mailSender = (JavaMailSender) SpringUtil.getBean("mailSender");
	}

	/**
	 * 发送邮件
	 */
	public void send(){
		
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
            this.mailSender.send(message);  
		} catch (Exception e) {
        	throw new SSOBusinessException("发送邮件失败 请重试！！！");
		}
	}
	
	
	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMyMail() {
		return myMail;
	}

	public void setMyMail(String myMail) {
		this.myMail = myMail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
