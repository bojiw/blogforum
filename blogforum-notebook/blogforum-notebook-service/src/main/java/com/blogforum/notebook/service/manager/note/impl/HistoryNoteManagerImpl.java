package com.blogforum.notebook.service.manager.note.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.tools.BaseConverter;
import com.blogforum.notebook.common.exception.NoteBusinessException;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.entity.HistoryNote;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.HistoryNoteVO;
import com.blogforum.notebook.service.manager.note.HistoryNoteManager;
import com.blogforum.notebook.service.note.HistoryNoteService;
import com.blogforum.notebook.service.note.NoteBodyService;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.sso.facade.model.UserVO;
@Service
public class HistoryNoteManagerImpl implements HistoryNoteManager {
	
	@Autowired
	private HistoryNoteService historyNoteService;
	
	@Autowired
	private NoteBodyService noteBodyService;
	
	@Autowired
	private NoteTitleService noteTitleService;

	@Override
	public Page<HistoryNoteVO> queryHistoryNote(UserVO user, String noteBodyId) {

		Page<HistoryNoteVO> pageNoteVO = new Page<>();
		//如果是普通用户则只获取前10条数据  后面会叫高级会员用户
		if (user.getRole() == 0) {
			Page<HistoryNote> historyNotePage = historyNoteService.getHistoryNotePage(new Page<HistoryNote>(1, 10), noteBodyId, user.getId());
			BeanUtils.copyProperties(historyNotePage, pageNoteVO, "list");
			BaseConverter<HistoryNote, HistoryNoteVO> noteConverter = new BaseConverter<>();
			List<HistoryNoteVO> convertList = noteConverter.convertList(historyNotePage.getList(), HistoryNoteVO.class);
			pageNoteVO.setList(convertList);
		}
		return pageNoteVO;
	}

	@Override
	public void updateRestoreNote(UserVO user, String noteBodyId, String historyId,String noteTitleId) {
		
		//获取当前要还原的历史笔记
		HistoryNote historyNoteContion = new HistoryNote(user.getId(), historyId, noteBodyId);
		HistoryNote historyNote = historyNoteService.getById(historyNoteContion);
		if (historyNote == null) {
			throw new NoteBusinessException("没有找到对应的历史笔记,请刷新!");
		}
		//获取当前的笔记内容和笔记标题
		NoteBody noteBodyContion = new NoteBody(user.getId(), noteBodyId, null);
		NoteBody noteBody = noteBodyService.getById(noteBodyContion);
		NoteTitle noteTitleContion = new NoteTitle(user.getId(), noteTitleId, null);
		NoteTitle noteTitle = noteTitleService.getById(noteTitleContion);
		//通过noteBody和notetitle拼装成历史笔记 保存到历史笔记中
		HistoryNote buildHistoryNote = new HistoryNote(noteBody,noteTitle);
		historyNoteService.save(buildHistoryNote);
		//再把要还原的历史笔记内容更新到笔记表中
		buildNoteBody(noteBody, historyNote);
		noteBodyService.update(noteBody);
		buildNoteTitle(noteTitle, historyNote);
		noteTitleService.update(noteTitle);
		
	}

	/**
	 * 把历史笔记里的内容移到笔记头信息里
	 * @param noteTitle
	 * @param historyNote
	 * @author: wwd
	 * @time: 2018年2月3日
	 */
	void buildNoteTitle(NoteTitle noteTitle,HistoryNote historyNote){
		noteTitle.setNoteBookId(historyNote.getNoteBookId());
		noteTitle.setNoteBookName(historyNote.getNoteBookName());
		noteTitle.setNoteContext(historyNote.getNoteContext());
		noteTitle.setType(historyNote.getType());
	}
	
	/**
	 * 把历史笔记里的内容移到笔记信息里
	 * @param noteBody
	 * @param historyNote
	 * @author: wwd
	 * @time: 2018年2月3日
	 */
	void buildNoteBody(NoteBody noteBody,HistoryNote historyNote){
		noteBody.setMdNoteBody(historyNote.getMdNoteBody());
		noteBody.setNoteBody(historyNote.getNoteBody());
		noteBody.setImageContext(historyNote.getImageContext());
		noteBody.setDelFlag(historyNote.getDelFlag());
		noteBody.setExtjson(historyNote.getExtjson());
		noteBody.setEnclosure(historyNote.getEnclosure());
		noteBody.setLabel(historyNote.getLabel());
		noteBody.setNoteTitleName(historyNote.getNoteTitleName());
		noteBody.setTextType(historyNote.getTextType());
	}
	

	
	
}
