package com.blogforum.sso.service.loginregistration;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.docking.facade.model.VerificationEmailVO;
import com.blogforum.sso.facade.enums.SsoMsgExchangeNameEnum;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.constant.ServiceConstant;
import com.blogforum.sso.service.rabbitmq.producer.SendMqMessage;

@Component
public class SendMailRegister extends AbstractLoginRegister {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	/** 发送消息类 */
	@Autowired
	private SendMqMessage	sendMqMessage;

	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		User user = context.getUser();
		//效验参数
		checkMailValue(user, "0000");
		//获取验证码
		String verificationCode = getVerificationCodeAndSetExRedis(user.getEmail());

		//发送邮件  传入接收邮件人 邮件主题  邮件内容
		sendMqMessage.sendMsg(
							buildEmailVO(user.getEmail(), "欢迎注册博记系统账户",
												buildMailInfo(verificationCode)),
							SsoMsgExchangeNameEnum.SSO_FANOUT_VERIFICATION_MAIL);

		logger.info(MessageFormat.format("成功发送邮件，邮箱为:{0},邮件内容为{1}{2}", user.getEmail(), verificationCode,
							ServiceConstant.subject));
		return blogforumResult.ok();

	}

	private VerificationEmailVO buildEmailVO(String mail, String subject, String mailInfo) {
		VerificationEmailVO emailVO = new VerificationEmailVO();
		emailVO.setMail(mail);
		emailVO.setSubject(subject);
		emailVO.setMailInfo(mailInfo);
		return emailVO;

	}

	/**
	 * 拼装邮件信息
	 * 
	 * @param user
	 * @return
	 */
	private String buildMailInfo(String verificationCode) {
		StringBuffer mailInfo = new StringBuffer();
		mailInfo.append("注册码为:  ").append(verificationCode).append("。");
		return mailInfo.toString();

	}

}
