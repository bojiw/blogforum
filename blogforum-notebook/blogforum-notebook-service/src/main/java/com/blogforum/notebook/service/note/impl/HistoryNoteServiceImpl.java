package com.blogforum.notebook.service.note.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.dao.mapper.HistoryNoteMapper;
import com.blogforum.notebook.pojo.entity.HistoryNote;
import com.blogforum.notebook.service.CrudService;
import com.blogforum.notebook.service.note.HistoryNoteService;

@Service
public class HistoryNoteServiceImpl extends CrudService<HistoryNote> implements HistoryNoteService {

	@Autowired
	private HistoryNoteMapper historyNoteMapper;
	
	@Override
	public Page<HistoryNote> getHistoryNotePage(Page<HistoryNote> page, String noteBodyId,String userId) {
		HistoryNote historyNoteCondition = new HistoryNote(userId, noteBodyId);
		historyNoteCondition.setPage(page);
		page.setList(historyNoteMapper.queryByNoteBodyId(historyNoteCondition));
		return page;
	}

	

	
}
