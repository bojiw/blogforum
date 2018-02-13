package com.blogforum.notebook.service.rabbitmq.producer;

import com.blogforum.notebook.facade.enums.NoteMsgExchangeNameEnum;
import com.blogforum.notebook.facade.enums.NoteMsgRouterKeyEnum;

/**
 * 消息发送接口
 * @author wwd
 *
 */
public interface SendMqMessage {
	
	/**
	 * 发送消息 只指定交换机
	 * @param content
	 * @param exchangeName
	 * @author: wwd
	 * @time: 2017年12月1日
	 */
	public void sendMsg(Object content, NoteMsgExchangeNameEnum exchangeName);
	

	/**
	 * 发送消息 指定交换机和路由key
	 * @param content消息内容
	 * @param exchangeName 交换机名
	 * @param queueName 队列名
	 * @author: wwd
	 * @time: 2017年11月19日
	 */
	public void sendMsg(Object content, NoteMsgExchangeNameEnum exchangeName, NoteMsgRouterKeyEnum routingKey);
}
