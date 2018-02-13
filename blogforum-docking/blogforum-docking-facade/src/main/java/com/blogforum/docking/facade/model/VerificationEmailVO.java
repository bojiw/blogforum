package com.blogforum.docking.facade.model;

public class VerificationEmailVO extends SuperModel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -7255034239219997799L;

	/** 目标邮箱 */
	private String				mail;

	/** 短信主题 */
	private String				subject;

	/** 短信内容 */
	private String				mailInfo;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailInfo() {
		return mailInfo;
	}

	public void setMailInfo(String mailInfo) {
		this.mailInfo = mailInfo;
	}

}
