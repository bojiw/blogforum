package com.blogforum.notebook.service.manager.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.SearchNoteRequestVO;
import com.blogforum.notebook.service.manager.search.SearchManager;
import com.blogforum.notebook.service.search.NoteSearchService;

@Service
public class SearchManagerImpl implements SearchManager {
	
	@Autowired
	private NoteSearchService noteSearchService;

	@Override
	public Page<NoteTitleVO> searchNote(SearchNoteRequestVO requestVO) {
		Page<NoteTitleVO> searchNotePage = noteSearchService.searchNotePage(requestVO);
		return searchNotePage;
	}

	
	
}
