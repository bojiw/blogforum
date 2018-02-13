package com.blogforum.docking.service.mail;

import java.util.HashMap;

/**
 * 邮件发送服务
 * 
 * @author wwd
 *
 */
public interface MailSend {
	/**
	 * 发送邮件
	 * 
	 * @param toMail
	 *            邮件接收人
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param extended
	 *            扩展字段如文件路径 传附件之类用
	 */
	public void send(String toMail, String subject, String text, HashMap<String, Object> extended);
}
