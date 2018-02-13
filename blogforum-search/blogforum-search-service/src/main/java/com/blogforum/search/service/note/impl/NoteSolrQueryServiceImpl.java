package com.blogforum.search.service.note.impl;

import java.util.Date;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.blogforum.search.common.exception.SearchBusinessException;
import com.blogforum.search.common.utils.LoggerUtil;
import com.blogforum.search.dao.solr.SolrClient;
import com.blogforum.search.facade.model.NoteSearchVO;
import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.pojo.vo.SolrPage;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.service.note.NoteSolrQueryService;

public class NoteSolrQueryServiceImpl implements NoteSolrQueryService {
	private final static Logger LOGGER =  LoggerFactory.getLogger(NoteSolrQueryServiceImpl.class);
	private SolrClient noteSolrClent;
	
	@Override
	public SearchPage defaultQuery(RequestQuerySearch request) {
		SolrDocumentList results = null;
		try {
			//把分页参数转换为solr的分页参数
			SolrPage page = new SolrPage(request.getPageNo(), request.getPageSize());
			//查询
			results = noteSolrClent.query(page, request);
		} catch (Exception e) {
			LoggerUtil.error(LOGGER,e, "查询note库失败,request={0}",JSON.toJSONString(request));
			throw new SearchBusinessException("查询note库失败", e);
		}
		SearchPage page = buildNote(results, request.getPageNo(), request.getPageSize());
		return page;
	}

	
	/**
	 * 拼装结果 返回Note分页对象
	 * @param results
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author: wwd
	 * @time: 2018年1月14日
	 */
	private SearchPage buildNote(SolrDocumentList results,Integer pageNo,Integer pageSize){
		//把请求页数 页数大小 还有能查询到的总条数通过page的构造函数计算出当前分页的状况
		SearchPage page = new SearchPage(pageNo,pageSize,results.getNumFound());
		for (SolrDocument solrDocument : results) {
			NoteSearchVO noteSolrVO = new NoteSearchVO();
			noteSolrVO.setId((String) solrDocument.get("id"));
			noteSolrVO.setNoteBookId((String) solrDocument.get("note_book_id"));
			noteSolrVO.setNoteTitle((String) solrDocument.get("note_title"));
			noteSolrVO.setNoteBookName((String) solrDocument.get("note_book_name"));
			noteSolrVO.setNoteContext((String) solrDocument.get("note_context"));
			noteSolrVO.setType((String) solrDocument.get("type"));
			noteSolrVO.setUpdateDate((Date) solrDocument.get("update_date"));
			noteSolrVO.setUserId((String) solrDocument.get("user_id"));
			page.getList().add(noteSolrVO);
		}
		return page;
	}
	
	
	public void setNoteSolrClent(SolrClient noteSolrClent) {
		this.noteSolrClent = noteSolrClent;
	}
	
	

}
