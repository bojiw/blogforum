package com.blogforum.docking.service.rabbitmq.consumer.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import com.alibaba.fastjson.JSON;
import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.docking.common.exception.DockingBusinessException;
import com.blogforum.docking.facade.enums.SmsTemplateEnum;
import com.blogforum.docking.facade.model.VerificationSmsVO;
import com.blogforum.docking.service.rabbitmq.consumer.Handler;
import com.blogforum.docking.service.sms.SmsSend;

/**
 * 发送短信验证码处理类
 * 
 * @author wwd
 *
 */
public class VerificationSmsHandler implements Handler {
	private static Logger logger = LoggerFactory.getLogger(VerificationSmsHandler.class);
	private SmsSend smsSend;

	@Override
	public void doHandler(Message message, String messageInfo) {

		
		VerificationSmsVO verificatioin = JSON.parseObject(messageInfo, VerificationSmsVO.class);
		String phoneNumber = verificatioin.getIphoneNumber();
		String verificationCode = verificatioin.getVerificationCode();
		SmsTemplateEnum smsTemplateEnum = verificatioin.getSmsTemplateEnum();
		checkValue(phoneNumber, verificationCode, smsTemplateEnum, message,messageInfo);
		Map<String, Object> extended = new HashMap<>();
		//设置短信标签
		extended.put("signName", smsTemplateEnum.getSignName());
		//设置短信模板
		extended.put("templateCode", smsTemplateEnum.getTemplateCode());
		//设置需要短信模板变量为生成的验证码
		StringBuffer templateParam = new StringBuffer();
		templateParam.append("{\"number\":\"").append(verificationCode).append("\"}");
		//发送短信
		smsSend.send(verificatioin.getIphoneNumber(), templateParam.toString(), extended);


	}

	private void checkValue(String phoneNumber, String verificationCode, SmsTemplateEnum smsTemplateEnum,
						Message message,String messageInfo) {
		if (StringUtils.isBlank(phoneNumber) || StringUtils.isBlank(verificationCode)
							|| smsTemplateEnum == null) {
			logger.error(new StringBuffer("入参为空").append(messageInfo).append(message.toString()).toString());
			throw new DockingBusinessException(BizErrorEnum.ILLEGAL_PARAMETER);
		}

	}

	public void setSmsSend(SmsSend smsSend) {
		this.smsSend = smsSend;
	}

}
