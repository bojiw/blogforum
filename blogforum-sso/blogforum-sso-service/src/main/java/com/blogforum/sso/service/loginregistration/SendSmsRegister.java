package com.blogforum.sso.service.loginregistration;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.docking.facade.enums.SmsTemplateEnum;
import com.blogforum.docking.facade.model.VerificationSmsVO;
import com.blogforum.sso.facade.enums.SsoMsgExchangeNameEnum;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.rabbitmq.producer.SendMqMessage;

@Component
public class SendSmsRegister extends AbstractLoginRegister {
	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SendMqMessage	sendMqMessage;

	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		User user = context.getUser();
		checkSmsValue(user, "0000");
		//获取验证码
		String verificationCode = getVerificationCodeAndSetExRedis(user.getIphone());
		//发送短信消息到对接第三方系统docking
		sendMqMessage.sendMsg(buildSmsVO(user.getIphone(), verificationCode),
							SsoMsgExchangeNameEnum.SSO_FANOUT_VERIFICATION_SMS);
		logger.info(MessageFormat.format("成功发送短信 手机号为:{0}，验证码为：{1}", user.getIphone(), verificationCode));
		return blogforumResult.ok();
	}

	private VerificationSmsVO buildSmsVO(String iphone, String templateParam) {
		VerificationSmsVO smsVO = new VerificationSmsVO();
		smsVO.setIphoneNumber(iphone);
		smsVO.setVerificationCode(templateParam);
		smsVO.setSmsTemplateEnum(SmsTemplateEnum.Verification);
		return smsVO;
	}

}
