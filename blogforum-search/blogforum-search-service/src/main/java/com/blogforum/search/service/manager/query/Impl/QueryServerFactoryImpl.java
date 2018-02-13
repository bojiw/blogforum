package com.blogforum.search.service.manager.query.Impl;

import java.util.Map;

import com.blogforum.search.service.manager.query.QueryHandler;
import com.blogforum.search.service.manager.query.QueryServerFactory;
import com.google.common.collect.Maps;

public class QueryServerFactoryImpl implements QueryServerFactory {
	
	private Map<String, QueryHandler> manager = Maps.newHashMap();

	@Override
	public QueryHandler getManager(String beanName) {
		return manager.get(beanName);
	}

	public void setManager(Map<String, QueryHandler> manager) {
		this.manager = manager;
	}
	
	
	

}
