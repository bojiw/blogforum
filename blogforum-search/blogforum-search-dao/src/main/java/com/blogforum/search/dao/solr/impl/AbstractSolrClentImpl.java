package com.blogforum.search.dao.solr.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.blogforum.search.common.constant.SolrQueryConstant;
import com.blogforum.search.dao.solr.SolrClient;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SortField;
import com.blogforum.search.pojo.vo.SolrPage;

public abstract class AbstractSolrClentImpl implements SolrClient {
	

	protected String			url;
	protected int				connectionTimeout;
	protected int				sockTimeout;
	protected HttpSolrClient	solrClient;

	@PostConstruct
	protected void init() {
		solrClient = new HttpSolrClient.Builder(url).withConnectionTimeout(connectionTimeout)
							.withSocketTimeout(sockTimeout).build();
	}

	@Override
	public SolrDocumentList query(SolrPage solrPage ,RequestQuerySearch request) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(request.getKeyword());
		query.setStart(solrPage.getStart());
		query.setRows(solrPage.getRows());
		query.addFacetField(request.getFields());
		query.set(SolrQueryConstant.DEFAULT_QUERY_FIELD, request.getDefaultQueryField());
		query.addFilterQuery(request.getFilters().toArray(new String[0]));
		//判断是否需要进行排序
		if (CollectionUtils.isNotEmpty(request.getSortfields())) {
			setSort(query, request.getSortfields());
		}
		QueryRequest qryReq = new QueryRequest(query);
		QueryResponse resp = qryReq.process(solrClient);
		return resp.getResults();
	}

	/**
	 * 给solr设置排序字段
	 * 
	 * @author: wwd
	 * @time: 2018年1月14日
	 */
	private void setSort(SolrQuery query,List<SortField> sortFields){
		for (SortField sortField : sortFields) {
			//获取对应的判断是降序还是升序的字段 如果是true为升序
			query.addSort(sortField.getSortField(), sortField.getSortflag() ? ORDER.asc : ORDER.desc);
			
		}
	}
	
	@Override
	public void deleteByQuery(String keywords) throws Exception {
		//搜索结果并且删除
		solrClient.deleteByQuery(keywords);
		solrClient.commit();

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inset() {
		// TODO Auto-generated method stub

	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public void setSockTimeout(int sockTimeout) {
		this.sockTimeout = sockTimeout;
	}

}
