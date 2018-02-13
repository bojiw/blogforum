package com.blogforum.search.service.facade.impl;

import com.blogforum.common.model.Result;
import com.blogforum.search.common.enums.ServiceEnum;
import com.blogforum.search.common.utils.Preconditions;
import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.service.SolrServiceFacade;
import com.blogforum.search.service.manager.query.QueryServerFactory;

public class SolrServiceFacadeImpl implements SolrServiceFacade {


	private QueryServerFactory		queryServerFactory;

	@Override
	public Result<SearchPage> query(RequestQuerySearch request) {
		Result<SearchPage> result = new Result<>();
		//效验参数
		checkVaule(request);
		String bean = ServiceEnum.getServerBeanByServerName(request.getServiceName());
		Preconditions.checkNotNull(bean, "找不到对应的服务,serverName{0}=", request.getServiceName());
		//查询
		SearchPage query = queryServerFactory.getManager(bean).query(request);
		result.setSuccess(true);
		result.setResultObj(query);
		return result;
	}

	/**
	 * 效验参数
	 * 
	 * @param keyword
	 * @param pageNo
	 * @param pageSize
	 * @author: wwd
	 * @time: 2018年1月14日
	 */
	private void checkVaule(RequestQuerySearch request) {
		Preconditions.checkNotNull(request, "请求对象不可为空");
		Preconditions.checkNotNull(request.getKeyword(), "查询关键字不可为空");
		Preconditions.checkNotNull(request.getServiceName(), "服务名不可为空");

	}

	public void setQueryServerFactory(QueryServerFactory queryServerFactory) {
		this.queryServerFactory = queryServerFactory;
	}

}
