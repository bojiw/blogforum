package com.blogforum.sso.service.sms;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.blogforum.sso.common.enums.SSOBizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

/**
 * 发送注册验证码类
 * @author Administrator
 *
 */
@Service("verificationSmsSend")
public class RegistrationVerificationSmsSend extends AbstractSmsSend {

	@Override
	public void send(String phoneNumbers, String templateParam,Map<String,Object> extended) {
		try {
			request.setPhoneNumbers(phoneNumbers);
			request.setSignName(extended.get("signName").toString());
			request.setTemplateCode(extended.get("templateCode").toString());
			request.setTemplateParam(templateParam);
			acsClient.getAcsResponse(request);
		} catch (Exception e) {
			throw new SSOBusinessException(SSOBizError.SMS_ERROR);
		}

	}

}
