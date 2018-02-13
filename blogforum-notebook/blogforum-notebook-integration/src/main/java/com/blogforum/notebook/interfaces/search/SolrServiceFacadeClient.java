package com.blogforum.notebook.interfaces.search;

import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;

public interface SolrServiceFacadeClient {
	
	/**
	 * 搜索solr中note core库里的笔记信息
	 * 
	 * @param request 搜索请求对象
	 * @return
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	SearchPage query(RequestQuerySearch request);
}
