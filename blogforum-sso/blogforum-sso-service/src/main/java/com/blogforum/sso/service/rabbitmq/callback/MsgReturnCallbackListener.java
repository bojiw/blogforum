package com.blogforum.sso.service.rabbitmq.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;

/**
 * 消息业务回调处理
 * @author wwd
 *
 */
@Component
public class MsgReturnCallbackListener implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println(message.toString());
		
	}

}
