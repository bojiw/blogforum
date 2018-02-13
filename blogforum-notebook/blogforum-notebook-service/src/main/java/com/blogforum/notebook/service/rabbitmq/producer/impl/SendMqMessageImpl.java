package com.blogforum.notebook.service.rabbitmq.producer.impl;

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
import com.blogforum.notebook.facade.enums.NoteMsgExchangeNameEnum;
import com.blogforum.notebook.facade.enums.NoteMsgRouterKeyEnum;
import com.blogforum.notebook.service.rabbitmq.producer.SendMqMessage;
@Component
public class SendMqMessageImpl implements SendMqMessage {

	private final static Logger LOGGER =  LoggerFactory.getLogger(SendMqMessageImpl.class);

	@Autowired
    private RabbitTemplate rabbitTemplate;  
	
	@Override
	public void sendMsg(Object content, NoteMsgExchangeNameEnum exchangeName) {
		sendMsg(content,exchangeName,NoteMsgRouterKeyEnum.DEFAULT_ROUTER_KEY);
		
		}

	@Override
	public void sendMsg(Object content, NoteMsgExchangeNameEnum exchangeName, NoteMsgRouterKeyEnum routingKey) {
		//转换为json
		String body = JSON.toJSONString(content);
		//回调id
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setMessageId(UUID.randomUUID().toString());
		Message message = new Message(body.getBytes(), messageProperties);
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(new StringBuffer("发送消息:").append(body).append(message.toString()).append("correlationId:").append(correlationId).toString());
		}
		rabbitTemplate.convertAndSend(exchangeName.getName(), routingKey.getName(), message, correlationId);
	}

}
