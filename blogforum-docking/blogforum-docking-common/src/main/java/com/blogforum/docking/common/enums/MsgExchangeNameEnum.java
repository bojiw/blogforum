package com.blogforum.docking.common.enums;

public enum MsgExchangeNameEnum {

	SSO_FANOUT_VERIFICATION_MAIL("sso_fanout_verification_mail", "verificationMailHandler", "接收用户需要发送的邮件请求"),
	
	SSO_FANOUT_VERIFICATION_SMS("sso_fanout_verification_sms", "verificationSmsHandler", "接收用户需要发送的手机请求"),
	
	DIRECT_IMAGE_CONVER_STRING_DOCKING("direct_image_conver_string_docking","imageToStringHandler","图片转文字功能");
	
	

	/** 消息队列名称 */
	private String	queueName;
	/** 对应的处理bean类的名称 */
	private String	beanName;
	/** 描述 */
	private String	memo;

	private MsgExchangeNameEnum(String queueName, String beanName, String memo) {
		this.queueName = queueName;
		this.beanName = beanName;
		this.memo = memo;
	}

	public static String getBeanNameByExchangeName(String queueName){
		for (MsgExchangeNameEnum msg : values()) {
			if (msg.getQueueName().equals(queueName)) {
				return msg.getBeanName();
			}
		}
		return null;
	}
	
	
	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
