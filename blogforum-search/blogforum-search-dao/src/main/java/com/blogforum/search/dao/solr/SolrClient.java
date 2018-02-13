package com.blogforum.search.dao.solr;

import org.apache.solr.common.SolrDocumentList;

import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.pojo.vo.SolrPage;

public interface SolrClient {

	/**
	 * 查询solr数据
	 * 
	 * @param solrPage	solr分页请求参数
	 * @param request 查询请求参数
	 * @return
	 * @throws Exception
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	SolrDocumentList query(SolrPage solrPage,RequestQuerySearch request) throws Exception ;
	
	/**
	 * 删除索引 根据搜索条件 把搜索出来的结果删除 目前设计为搜索id
	 * @param keywords
	 * @author: wwd
	 * @time: 2018年1月14日
	 */
	void deleteByQuery(String keywords)throws Exception;
	
	void update();
	
	void inset();
}
