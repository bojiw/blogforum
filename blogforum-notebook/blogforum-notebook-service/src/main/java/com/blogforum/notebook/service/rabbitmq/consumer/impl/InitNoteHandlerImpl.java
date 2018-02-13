package com.blogforum.notebook.service.rabbitmq.consumer.impl;

import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.blogforum.common.tools.UUIDCreateUtils;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;
import com.blogforum.notebook.common.enums.NoteTextTypeEnum;
import com.blogforum.notebook.common.enums.NoteTypeEnum;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteBook;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.service.note.NoteBodyService;
import com.blogforum.notebook.service.note.NoteBookService;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.notebook.service.rabbitmq.consumer.Handler;
import com.blogforum.sso.facade.model.UserVO;

/**
 * 用户注册时笔记系统一些初始化准备
 * 
 * @author wwd
 *
 */
public class InitNoteHandlerImpl implements Handler {

	@Autowired
	private NoteBookService		noteBookService;

	@Autowired
	private NoteTitleService	noteTitleService;

	@Autowired
	private NoteBodyService		noteBodyService;

	private static String		noteTitleName	= "欢迎来到博记系统";

	@Override
	public void doHandler(Message message, String messageInfo) {

		UserVO userVO = JSON.parseObject(messageInfo, UserVO.class);
		String userId = userVO.getId();
		//1、创建默认笔记本
		String noteBookId = createNoteBook(userId);
		//2、创建笔记标题
		String noteTiltleId = createNoteTitle(userId, noteBookId);
		//3、创建笔记内容
		createNoteBody(userId, noteTiltleId);
	}

	/**
	 * 创建笔记本
	 * 
	 * @param userId
	 * @author: wwd
	 * @time: 2017年12月1日
	 */
	private String createNoteBook(String userId) {
		NoteBook noteBook = new NoteBook();
		String id = UUIDCreateUtils.getUUID();
		noteBook.setId(id);
		noteBook.setUserId(userId);
		noteBook.setParentId("0");
		noteBook.setName("默认笔记");
		noteBook.setHaveNode(false);
		noteBookService.save(noteBook);
		return id;
	}

	/**
	 * 创建笔记标题
	 * 
	 * @param userId
	 * @param noteBookId
	 * @return
	 * @author: wwd
	 * @time: 2017年12月1日
	 */
	private String createNoteTitle(String userId, String noteBookId) {
		NoteTitle noteTitle = new NoteTitle();
		String id = UUIDCreateUtils.getUUID();
		noteTitle.setId(id);
		noteTitle.setUserId(userId);
		noteTitle.setDelFlag(IsDelFlagEnum.N.getValue());
		noteTitle.setNoteBookId(noteBookId);
		noteTitle.setNoteBookName("默认笔记");
		noteTitle.setNoteTitle(noteTitleName);
		noteTitle.setType(NoteTypeEnum.SIMPLENOTE.getValue());
		noteTitle.setNoteContext("<p>接下来开始介绍下系统的使用</p>");
		noteTitleService.save(noteTitle);
		return id;
	}

	private void createNoteBody(String userId, String noteTitleId) {
		NoteBody noteBody = new NoteBody();
		String id = UUIDCreateUtils.getUUID();
		noteBody.setId(id);
		noteBody.setUserId(userId);
		noteBody.setNoteTitleId(noteTitleId);
		noteBody.setNoteTitleName(noteTitleName);
		noteBody.setLabel("默认笔记");
		noteBody.setDelFlag(IsDelFlagEnum.N.getValue());
		noteBody.setTextType(NoteTextTypeEnum.ORIGINAL.getMemo());
		noteBody.setNoteBody("接下来开始介绍下系统的使用");
		noteBodyService.save(noteBody);
	}

}
