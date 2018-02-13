package com.blogforum.notebook.service.search.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.blogforum.notebook.common.constant.SearchConstant;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.interfaces.search.SolrServiceFacadeClient;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.SearchNoteRequestVO;
import com.blogforum.notebook.service.search.NoteSearchService;
import com.blogforum.search.facade.model.NoteSearchVO;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;

@Service
public class NoteSearchServiceImpl implements NoteSearchService {

	@Autowired
	private SolrServiceFacadeClient solrServiceFacadeClient;
	
	@Override
	public Page<NoteTitleVO> searchNotePage(SearchNoteRequestVO searchNoteVO) {
		
		RequestQuerySearch request = buildRequest(searchNoteVO);
		SearchPage searchNote = solrServiceFacadeClient.query(request);
		return buildNoteVO(searchNote);
	}
	
	/**
	 * 拼装返回参数
	 * @param searchNote
	 * @return
	 * @author: wwd
	 * @time: 2018年1月21日
	 */
	private Page<NoteTitleVO> buildNoteVO(SearchPage searchNote){
		Page<NoteTitleVO> page = new Page<>(searchNote.getPageNo(), searchNote.getPageSize(),searchNote.getCount());
		List<Object> list = searchNote.getList();
		if (CollectionUtils.isEmpty(list)) {
			return page;
		}
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			NoteSearchVO note = (NoteSearchVO) iterator.next();
			NoteTitleVO noteTitleVO = new NoteTitleVO();
			noteTitleVO.setId(note.getId());
			noteTitleVO.setUpdateDate(note.getUpdateDate());
			noteTitleVO.setNoteBookId(note.getNoteBookId());
			noteTitleVO.setNoteContext(note.getNoteContext());
			noteTitleVO.setNoteTitle(note.getNoteTitle());
			noteTitleVO.setNoteBookName(note.getNoteBookName());
			noteTitleVO.setType(note.getType());
			page.add(noteTitleVO);
		}
		return page;
		
	}
	
	
	/**
	 * 拼装查询请求对象
	 * @param searchNoteVO
	 * @return
	 * @author: wwd
	 * @time: 2018年1月21日
	 */
	private RequestQuerySearch buildRequest(SearchNoteRequestVO searchNoteVO){
		RequestQuerySearch request = new RequestQuerySearch();
		request.setKeyword(searchNoteVO.getKeyword());
		request.setPageNo(searchNoteVO.getPageNo());
		request.setPageSize(searchNoteVO.getPageSize());
		request.setServiceName(SearchConstant.SEARCH_NOTE_SERVERNAME);
		request.setFilters(SearchConstant.USER_ID, searchNoteVO.getUserId());
		request.setDefaultQueryField(SearchConstant.NOTE_KEYWORDS);
		if (StringUtils.isNotEmpty(searchNoteVO.getNoteBookId()) ) {
			request.setFilters(SearchConstant.NOTE_BOOK_ID, searchNoteVO.getNoteBookId());
		}
		return request;
	}
	

}
