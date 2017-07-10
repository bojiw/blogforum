package com.blogforum.sso.service.loginregistration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  
@EnableAutoConfiguration
public class LoginRegistrationFactoryConfig {
	
	@Autowired
	private SendMailRegistration sendMailRegistration;
	
	@Bean
	public AbstractLoginRegistrationFactory abstractLoginRegistrationFactory(){
		//创建一个登录注册工厂实例
		AbstractLoginRegistrationFactoryImpl abstractLoginRegistrationFactory = new AbstractLoginRegistrationFactoryImpl();
		Map<String, LoginRegistration> manager = new HashMap<>();
		//设置工厂中的bean
		manager.put("sendMailRegistration", sendMailRegistration);
		abstractLoginRegistrationFactory.setManager(manager);
		return abstractLoginRegistrationFactory;
	}

}
