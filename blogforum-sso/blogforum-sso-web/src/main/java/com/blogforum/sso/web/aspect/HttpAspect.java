package com.blogforum.sso.web.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.blogforum.common.tools.IpUtils;
/**
 * aop打印http日志类
 * @author wwd
 *
 */
@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.blogforum.sso.web.controller.*.*(..))")
	public void log(){
	}
	
	/**
	 * 获取请求日志
	 */
	@Before("log()")
	public void doBefore(){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//获取真实ip
		String ip = IpUtils.getIp(request);
		logger.info("ip地址为：{}",ip);
		logger.info(attributes.getRequest().toString());
	}
	

	/**
	 * 获取返回日志
	 */
	@AfterReturning(returning = "object",pointcut = "log()")
	public void doAfterReturning(Object object){
		logger.info(object.toString());
	}
	
}
