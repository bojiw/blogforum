package com.blogforum.notebook.service.rabbitmq.consumer;

import org.springframework.amqp.core.Message;

public interface Handler {

	/**
	 * 接收消息执行的handler
	 * @param message
	 * @author: wwd
	 * @time: 2017年11月21日
	 */
	public void doHandler(Message message,String messageInfo);
	
}
