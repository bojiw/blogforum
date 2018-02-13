package com.blogforum.sso.service.rabbitmq.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.blogforum.sso.facade.enums.SsoMsgExchangeNameEnum;
import com.blogforum.sso.service.rabbitmq.callback.MsgConfirmCallbackListener;
import com.blogforum.sso.service.rabbitmq.callback.MsgReturnCallbackListener;

/**
 * rabbitmq配置类
 * 
 * @author wwd exchange:交换机名称 routingKey:路由关键字 object:发送的消息内容
 *         correlationData:消息ID
 */
@Configuration
public class AmqpConfig {

	@Value("${rabbitmq.addresses}")
	private String						address;
	@Value("${rabbitmq.username}")
	private String						userName;
	@Value("${rabbitmq.password}")
	private String						password;
	@Value("${rabbitmq.virtual-host}")
	private String						virtualHost;
	@Value("${rabbitmq.publisher-confirms}")
	private boolean						publisherConfirms;
	@Value("${rabbitmq.channelCacheSize}")
	private int							channelCacheSize;
	

	@Autowired
	private MsgConfirmCallbackListener	msgConfirmCallbackListener;

	@Autowired
	private MsgReturnCallbackListener	msgReturnCallbackListener;

	//因为要使用回调功能 所以不能使用spring默认配置 
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(address);
		connectionFactory.setUsername(userName);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(virtualHost);
		connectionFactory.setPublisherConfirms(publisherConfirms); //开启消息的回调
		connectionFactory.setPublisherReturns(true);//开启错误回调
		connectionFactory.setChannelCacheSize(channelCacheSize);//设置信道缓存大小
		return connectionFactory;
	}

	/**
	 * 声明一个topic交换机 开启持久化功能 当所有消费客户端连接断开后，自动删除队列
	 * 
	 * @return
	 * @author: wwd
	 * @time: 2017年11月26日
	 */
	@Bean
	public TopicExchange ssoTopicExchange() {
		return new TopicExchange(SsoMsgExchangeNameEnum.SSO_TOPIC_EXCHANGE.getName(), true, false);
	}

	
	/**
	 * 声明一个广播交换机 发送用户创建的消息 开启持久化功能 当所有消费客户端连接断开后，自动删除队列
	 * @return
	 * @author: wwd
	 * @time: 2017年12月1日
	 */
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(SsoMsgExchangeNameEnum.SSO_FANOUT_INIT_USER.getName(), true, false);
	}
	
	@Bean
	public FanoutExchange smsFanoutExchange() {
		return new FanoutExchange(SsoMsgExchangeNameEnum.SSO_FANOUT_VERIFICATION_SMS.getName(), true, false);
	}
	
	@Bean
	public FanoutExchange mailFanoutExchange() {
		return new FanoutExchange(SsoMsgExchangeNameEnum.SSO_FANOUT_VERIFICATION_MAIL.getName(), true, false);
	}
	
//	/**
//	 * 声明一个队列 开启队列持久化功能
//	 * 
//	 * @return
//	 * @author: wwd
//	 * @time: 2017年11月18日
//	 */
//	@Bean
//	public Queue ssoInitUserTopicQueue() {
//		return new Queue("sso_init_user_queue_key", true);
//	}
//
//	/**
//	 * 将队列ssoInitUserTopicQueue与ssoTopicExchange绑定
//	 * 
//	 * @param queueMessage
//	 * @param exchange
//	 * @return
//	 */
//	@Bean
//	public Binding bindingExchangeMessage(Queue ssoInitUserTopicQueue, TopicExchange ssoTopicExchange) {
//		return BindingBuilder.bind(ssoInitUserTopicQueue).to(ssoTopicExchange)
//							.with(SsoMsgQueueNameEnum.SSO_INITUSER_QUEUE_KEY.getName());
//	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	//因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		//设置回调函数
		template.setConfirmCallback(msgConfirmCallbackListener);
		template.setReturnCallback(msgReturnCallbackListener);
		template.setMandatory(true);
		//template.setEncoding("UTF-8");
		return template;
	}

}
