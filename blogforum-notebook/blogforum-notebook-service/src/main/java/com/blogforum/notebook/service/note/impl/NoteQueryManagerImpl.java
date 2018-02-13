package com.blogforum.notebook.service.note.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.tools.BaseConverter;
import com.blogforum.notebook.common.exception.NoteBusinessException;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteBook;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteBodyVO;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.service.note.NoteBodyService;
import com.blogforum.notebook.service.note.NoteBookService;
import com.blogforum.notebook.service.note.NoteQueryManager;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.sso.facade.model.UserVO;
import com.google.common.collect.Lists;

@Service
public class NoteQueryManagerImpl implements NoteQueryManager {
	@Autowired
	private NoteTitleService	noteTitleService;
	@Autowired
	private NoteBookService		noteBookService;
	@Autowired
	private NoteBodyService		noteBodyService;

	@Override
	public Page<NoteTitleVO> queryNoteTitle(Page<NoteTitle> page, UserVO user, String noteBookId) {
		Page<NoteTitleVO> pageNoteVO = new Page<>();
		List<NoteTitleVO> noteTitleVOs = Lists.newArrayList();
		//创建查询条件 通过userId和notebookId查询
		NoteTitle noteTitleCondition = new NoteTitle(user.getId(), noteBookId);
		Page<NoteTitle> pageNoteTitle = noteTitleService.queryList(page, noteTitleCondition);
		//转换成VO
		BeanUtils.copyProperties(page, pageNoteVO, "list");
		BaseConverter<NoteTitle, NoteTitleVO> noteConverter = new BaseConverter<>();
		noteTitleVOs = noteConverter.convertList(pageNoteTitle.getList(), NoteTitleVO.class);
		pageNoteVO.setList(noteTitleVOs);
		return pageNoteVO;
	}

	@Override
	public List<NoteBookVO> queryNoteBook(UserVO user, String parentId) {
		//创建查询条件 通过用户id和父Id查询
		NoteBook noteBookCondition = new NoteBook(user.getId(), parentId);
		List<NoteBook> books = noteBookService.queryListByParentId(noteBookCondition);
		BaseConverter<NoteBook, NoteBookVO> converter = new BaseConverter<>();
		List<NoteBookVO> notebooks = converter.convertList(books, NoteBookVO.class);
		for (NoteBookVO noteBookVO : notebooks) {
			noteBookVO.setNoteCount(noteTitleService.countByNoteBookId(noteBookVO.getId()));
		}
		return notebooks;
	}

	@Override
	public NoteBodyVO queryNoteBody(UserVO user, NoteTitle noteTitle) {
		NoteBody bodyCondition = new NoteBody(user.getId(), noteTitle.getId());
		NoteBody noteBody = noteBodyService.getByNoteTitleId(bodyCondition);
		if (noteBody == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,
								new StringBuilder("查询不到笔记对应内容!noteTitleId:").append(noteTitle.getId()).toString());
		}
		BaseConverter<NoteBody, NoteBodyVO> noteConverter = new BaseConverter<>();
		NoteBodyVO noteBodyVO = noteConverter.convert(noteBody, NoteBodyVO.class);
		return noteBodyVO;
	}

	@Override
	public List<NoteBookVO> getSearchNoteBook(UserVO user) {
		//1、查询当前用户下所有笔记本
		NoteBook noteBookCondition = new NoteBook();
		noteBookCondition.setUserId(user.getId());
		List<NoteBook> noteBooks = noteBookService.queryList(noteBookCondition);
		//2、转换成前端需要的VO
		BaseConverter<NoteBook, NoteBookVO> converter = new BaseConverter<>();
		List<NoteBookVO> newNotebooks = converter.convertList(noteBooks, NoteBookVO.class);
		return newNotebooks;
	}

}
