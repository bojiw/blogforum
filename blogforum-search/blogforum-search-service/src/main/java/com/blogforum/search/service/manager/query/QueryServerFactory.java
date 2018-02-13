package com.blogforum.search.service.manager.query;

public interface QueryServerFactory {
	
	QueryHandler getManager(String beanName);
	

}
