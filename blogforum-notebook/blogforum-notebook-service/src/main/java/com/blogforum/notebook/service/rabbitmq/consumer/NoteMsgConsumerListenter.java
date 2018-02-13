package com.blogforum.notebook.service.rabbitmq.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.blogforum.notebook.common.enums.MsgExchangeNameEnum;
import com.rabbitmq.client.Channel;

/**
 * 接收sso系统消息处理类
 * @author wwd
 *
 */
public class NoteMsgConsumerListenter implements ChannelAwareMessageListener  {

	private static Logger logger = LoggerFactory.getLogger(NoteMsgConsumerListenter.class);
	
	/**消息对应的处理类*/
	private Map<String, Handler> msgHandler = new HashMap<String, Handler>();
	
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			//获取消息名 通过消息名找到对应的执行bean
			String msgName = message.getMessageProperties().getReceivedExchange();
			String beanName = MsgExchangeNameEnum.getBeanNameByExchangeName(msgName);
			//获取消息内容
			String messageinfo = new String(message.getBody());
			
			if (StringUtils.isEmpty(beanName) || StringUtils.isEmpty(messageinfo)) {
				StringBuffer loginfo = new StringBuffer();
				loginfo.append("消息对应的bean不存在或者消息内容为空 不进行处理:beanName=" ).append(beanName)
					.append("消息id").append(message.getMessageProperties().getMessageId())
					.append(",消息内容:").append(messageinfo);
				logger.warn(loginfo.toString());
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
				return;
			}
			Handler handler = msgHandler.get(beanName);
			if (logger.isInfoEnabled()) {
				logger.info("开始处理消息:" + handler.getClass().getName() + ",消息内容:" + message.toString());
			}
			handler.doHandler(message,messageinfo);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			//channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
			//channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			//TODO因为还没找到rabbitmq无限重试的处理方案 所以暂时采用打印日志处理
			logger.error("消息处理失败:" + message.toString(),e);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}

	}


	public void setMsgHandler(Map<String, Handler> msgHandler) {
		this.msgHandler = msgHandler;
	}

	
	
}
