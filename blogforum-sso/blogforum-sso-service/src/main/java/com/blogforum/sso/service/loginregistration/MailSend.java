package com.blogforum.sso.service.loginregistration;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.blogforum.sso.common.exception.SSOBusinessException;
import com.blogforum.sso.service.constant.ServiceConstant;

/**
 * 邮件发送类
 * @author Administrator
 *
 */
@Component
public class MailSend {
	
    @Autowired  
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
	}

	/**
	 * 发送邮件
	 */
	public void send(){
		
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();  
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage); 
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
            this.mailSender.send(mimeMessage);  
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
