package com.blogforum.docking.service.sms.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;

public class VerificationSmsSend extends AbstractSmsSend {
	private static final Logger logger = LoggerFactory.getLogger(VerificationSmsSend.class);

	@Override
	public void send(String phoneNumbers, String templateParam, Map<String, Object> extended) {
		try {
			/**阿里大鱼短信发送类*/
			SendSmsRequest request = new SendSmsRequest();
			request.setPhoneNumbers(phoneNumbers);
			request.setSignName(extended.get("signName").toString());
			request.setTemplateCode(extended.get("templateCode").toString());
			request.setTemplateParam(templateParam);
			acsClient.getAcsResponse(request);
		} catch (Exception e) {
			logger.error(new StringBuffer("发送短信失败,phoneNumbers=").append(phoneNumbers).append(",signName=").append(extended.get("signName").toString())
								.append(",templateCode=").append(extended.get("templateCode").toString()).append(",templateParam=").append(templateParam).toString(),e);
		}

	}

}
