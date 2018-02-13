package com.blogforum.notebook.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.service.note.NoteQueryManager;
import com.blogforum.notebook.web.constant.ViewConstant;
import com.blogforum.sso.facade.model.UserVO;

/**
 * 首页
 * 
 * @author wwd
 *
 */
@Controller
public class IndexController {
	@Autowired
	private NoteQueryManager	noteQueryService;



	@RequestMapping("/")
	public String index(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		UserVO user = (UserVO) request.getAttribute("user");
		//获取第一级笔记本
		List<NoteBookVO> noteBooks = noteQueryService.queryNoteBook(user, "0");
		Page<NoteTitleVO> notes = new Page<NoteTitleVO>();
		//获取笔记本下的前20条笔记标题
		if (CollectionUtils.isNotEmpty(noteBooks)) {
			notes = noteQueryService.queryNoteTitle(new Page<NoteTitle>(request, response), user,
								noteBooks.get(0).getId());
		}
		map.put("noteBooks", noteBooks);
		map.put("notes", notes);
		map.put("username", user.getUsername());
		map.put("userid", user.getId());
		map.put("userimage", user.getImage());
		return ViewConstant.INDEX;
	}

	@RequestMapping("/simplenote")
	public String simpleNote(ModelMap map, String noteBookName, String noteBookId, String noteId) {
		map.put("noteBookId", noteBookId);
		map.put("noteBookName", noteBookName);
		map.put("noteId", noteId);
		return ViewConstant.SIMPLENOTE;
	}

	@RequestMapping("/nullnote")
	public String nullNote(ModelMap map) {
		return ViewConstant.NULLNOTE;
	}

	@RequestMapping("/markdownnote")
	public String markDownNote(ModelMap map, String noteBookName, String noteBookId, String noteId) {
		map.put("noteBookId", noteBookId);
		map.put("noteBookName", noteBookName);
		map.put("noteId", noteId);
		return ViewConstant.MARKDOWNNOTE;
	}

	@RequestMapping("/historynote")
	public String historyNote(HttpServletRequest request, ModelMap map, String noteBodyId) {
		map.put("noteBodyId", noteBodyId);
		return ViewConstant.HISTORY;
	}

}
