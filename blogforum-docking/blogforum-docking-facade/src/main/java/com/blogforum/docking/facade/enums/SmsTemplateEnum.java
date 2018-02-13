package com.blogforum.docking.facade.enums;

public enum SmsTemplateEnum {
	/** 验证码短信签名和模板 */
	Verification("博记系统", "SMS_77240046");

	/** 短信标签 */
	private String	signName;

	/** 短信模板 */
	private String	templateCode;

	private SmsTemplateEnum(String signName, String templateCode) {
		this.signName = signName;
		this.templateCode = templateCode;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

}
