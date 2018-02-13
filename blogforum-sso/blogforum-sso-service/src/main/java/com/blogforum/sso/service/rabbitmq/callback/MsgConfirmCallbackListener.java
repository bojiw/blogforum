package com.blogforum.sso.service.rabbitmq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * 消息是否成功投递到rabbitmq 回调类
 * @author wwd
 *
 */
@Component
public class MsgConfirmCallbackListener implements ConfirmCallback {
	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());
	/**
	 * 消息的回调
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info(" 回调id:" + correlationData);
		if (ack) {
			logger.info("消息成功消费");
		} else {
			logger.error("消息消费失败:" + cause);
		}

	}
}
