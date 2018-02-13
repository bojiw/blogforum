package com.blogforum.sso.web.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * dubbo读取xml配置类
 * @author wwd
 *
 */
@Configuration
@ImportResource({"classpath:dubbo/*.xml"})
public class DubboConfig {

	
	
}
