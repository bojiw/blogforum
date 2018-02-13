package com.blogforum.notebook.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.service.note.NoteBookService;
import com.blogforum.notebook.service.note.NoteQueryManager;
import com.blogforum.sso.facade.model.UserVO;

@Controller
@RequestMapping("/noteBook")
public class NoteBookController {
	@Autowired
	private NoteBookService		noteBookService;

	@Autowired
	private NoteQueryManager			noteQueryManager;

	@RequestMapping("/getNoteBook/{parentId}")
	@ResponseBody
	public blogforumResult getNoteBooks(@PathVariable String parentId, HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		List<NoteBookVO> noteBooks = noteQueryManager.queryNoteBook(user, parentId);
		return blogforumResult.ok(noteBooks);
	}
	
	@RequestMapping("/getSearchNoteBook")
	@ResponseBody
	public blogforumResult getNoteBooks(HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		List<NoteBookVO> noteBooks = noteQueryManager.getSearchNoteBook(user);
		return blogforumResult.ok(noteBooks);
	}
	

	@RequestMapping(value = "/addNoteBook", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult addNoteBooks(String name, @RequestParam(defaultValue = "0") String parentId,
						HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		NoteBookVO noteBookVO = noteBookService.addBook(user, parentId, name);
		return blogforumResult.ok(noteBookVO);
	}

	@RequestMapping(value = "/updateNoteBook", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult updateNoteBooks(String id, String name, HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		NoteBookVO noteBookVO = noteBookService.updateBook(id, user, name);
		return blogforumResult.ok(noteBookVO);
	}

	@RequestMapping(value = "/deleteNoteBook", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult deleteNoteBook(String id, String parentId, HttpServletRequest request) {

		UserVO user = (UserVO) request.getAttribute("user");
		Boolean isNode = noteBookService.deleteBook(id, parentId, user);
		return blogforumResult.ok(isNode);
	}

}
