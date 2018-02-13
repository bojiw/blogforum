package com.blogforum.docking.service.rabbitmq.consumer.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import com.alibaba.fastjson.JSON;
import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.docking.common.exception.DockingBusinessException;
import com.blogforum.docking.facade.model.VerificationEmailVO;
import com.blogforum.docking.service.mail.MailSend;
import com.blogforum.docking.service.rabbitmq.consumer.Handler;

/**
 * 发送邮件验证码处理类
 * 
 * @author wwd
 *
 */
public class VerificationMailHandler implements Handler {
	private static Logger	logger	= LoggerFactory.getLogger(VerificationMailHandler.class);

	private MailSend		mailSend;

	@Override
	public void doHandler(Message message, String messageInfo) {
		VerificationEmailVO mailVO = JSON.parseObject(messageInfo, VerificationEmailVO.class);
		String mail = mailVO.getMail();
		String mailInfo = mailVO.getMailInfo();
		String subject = mailVO.getSubject();
		//效验参数
		checkValue(mail, mailInfo, subject, message,messageInfo);
		logger.info(mail + mailInfo + subject);
		//发送短信
		mailSend.send(mail, subject, mailInfo, null);
		
		
	}

	private void checkValue(String mail, String mailInfo, String subject,
						Message message,String messageInfo) {
		if (StringUtils.isBlank(mail) || StringUtils.isBlank(mailInfo)
							|| StringUtils.isBlank(subject)) {
			logger.error(new StringBuffer("入参为空").append(messageInfo).append(message.toString()).toString());
			throw new DockingBusinessException(BizErrorEnum.ILLEGAL_PARAMETER);
		}

	}

	public void setMailSend(MailSend mailSend) {
		this.mailSend = mailSend;
	}

}
