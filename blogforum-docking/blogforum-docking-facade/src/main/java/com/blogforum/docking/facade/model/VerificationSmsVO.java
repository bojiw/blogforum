package com.blogforum.docking.facade.model;

import com.blogforum.docking.facade.enums.SmsTemplateEnum;

public class VerificationSmsVO extends SuperModel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5237643332081792066L;

	/** 发送目标手机号 */
	private String				iphoneNumber;

	/** 验证码 */
	private String				verificationCode;

	/** 短信标签 */
	private SmsTemplateEnum		smsTemplateEnum;

	public String getIphoneNumber() {
		return iphoneNumber;
	}

	public void setIphoneNumber(String iphoneNumber) {
		this.iphoneNumber = iphoneNumber;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public SmsTemplateEnum getSmsTemplateEnum() {
		return smsTemplateEnum;
	}

	public void setSmsTemplateEnum(SmsTemplateEnum smsTemplateEnum) {
		this.smsTemplateEnum = smsTemplateEnum;
	}

}
