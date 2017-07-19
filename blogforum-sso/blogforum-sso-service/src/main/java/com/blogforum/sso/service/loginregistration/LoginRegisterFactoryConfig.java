package com.blogforum.sso.service.loginregistration;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class LoginRegisterFactoryConfig {

	@Resource
	private LoginRegister	sendMailRegister;
	@Resource
	private LoginRegister	sendSmsRegister;
	@Resource
	private LoginRegister	mailRegister;
	@Resource
	private LoginRegister	smsRegister;
	@Resource
	private LoginRegister	login;

	@Bean
	public LoginRegisterFactory abstractLoginRegistrationFactory() {
		//创建一个登录注册工厂实例
		LoginRegisterFactoryImpl abstractLoginRegistrationFactory = new LoginRegisterFactoryImpl();
		Map<String, LoginRegister> manager = new HashMap<>();
		//设置工厂中的bean
		manager.put("sendMailRegister", sendMailRegister);
		manager.put("sendSmsRegister", sendSmsRegister);
		manager.put("mailRegister", mailRegister);
		manager.put("smsRegister", smsRegister);
		manager.put("login", login);
		abstractLoginRegistrationFactory.setManager(manager);
		return abstractLoginRegistrationFactory;
	}

}
