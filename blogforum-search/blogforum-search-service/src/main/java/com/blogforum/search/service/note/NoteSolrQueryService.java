package com.blogforum.search.service.note;

import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.facade.model.RequestQuerySearch;

/**
 * 笔记搜索服务
 * @author wwd
 *
 */
public interface NoteSolrQueryService {
	
	/**
	 * 默认搜索
	 * @param request 搜索请求对象
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	SearchPage defaultQuery(RequestQuerySearch request);

}
