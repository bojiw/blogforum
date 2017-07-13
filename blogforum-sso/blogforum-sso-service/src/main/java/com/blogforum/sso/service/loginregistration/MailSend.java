package com.blogforum.sso.service.loginregistration;

/**
 * 邮件发送服务
 * @author Administrator
 *
 */
public interface MailSend {

	/**
	 * 发送邮件
	 * @param toMail 邮件接收人
	 * @param subject 主题
	 * @param text 内容
	 */
	public void send(String toMail,String subject,String text);
	
}
