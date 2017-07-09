package com.blogforum.sso;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.blogforum.sso.dao.mapper")
public class Starter extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Starter.class);
	}
	
	/**
	 * druid连接数据库的密码进行了加密 为了解密 需要在这里设置 不然直接返回new DruidDataSource();就可以了
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druidDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		//设置密码解密
		dataSource.setConnectionProperties("config.decrypt=true");
		return dataSource;
	}
	
}
