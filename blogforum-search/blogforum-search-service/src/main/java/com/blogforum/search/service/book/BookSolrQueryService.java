package com.blogforum.search.service.book;

import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;

/**
 * 笔记本搜索服务
 * @author wwd
 *
 */
public interface BookSolrQueryService {
	
	/**
	 * 默认搜索
	 * @param request 搜索请求对象
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	SearchPage defaultQuery(RequestQuerySearch request);

}
