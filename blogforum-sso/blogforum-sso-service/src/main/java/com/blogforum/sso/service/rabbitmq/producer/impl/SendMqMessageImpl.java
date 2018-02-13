package com.blogforum.sso.service.rabbitmq.producer.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.blogforum.sso.facade.enums.SsoMsgExchangeNameEnum;
import com.blogforum.sso.facade.enums.SsoMsgRouterKeyEnum;
import com.blogforum.sso.service.rabbitmq.producer.SendMqMessage;


@Component
public class SendMqMessageImpl implements SendMqMessage {
	
	private final static Logger LOGGER =  LoggerFactory.getLogger(SendMqMessageImpl.class);
	private RabbitTemplate rabbitTemplate;

	/**
	 * 构造方法注入
	 */
	@Autowired
	public SendMqMessageImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMsg(Object content, SsoMsgExchangeNameEnum exchangeName, SsoMsgRouterKeyEnum routingKey) {
		//转换为json
		String body = JSON.toJSONString(content);
		//回调id
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setMessageId(UUID.randomUUID().toString());
		Message message = new Message(body.getBytes(), messageProperties);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(new StringBuffer("发送消息:").append(message.toString()).append("correlationId:").append(correlationId).toString());
		}
		rabbitTemplate.convertAndSend(exchangeName.getName(), routingKey.getName(), message, correlationId);
	}

	@Override
	public void sendMsg(Object content, SsoMsgExchangeNameEnum exchangeName) {
		sendMsg(content,exchangeName,SsoMsgRouterKeyEnum.DEFAULT_ROUTER_KEY);
		
	}
}
