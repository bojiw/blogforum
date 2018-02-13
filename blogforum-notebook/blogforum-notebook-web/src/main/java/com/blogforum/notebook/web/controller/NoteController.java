package com.blogforum.notebook.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteBodyVO;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.NoteVO;
import com.blogforum.notebook.pojo.vo.SearchNoteRequestVO;
import com.blogforum.notebook.service.manager.search.SearchManager;
import com.blogforum.notebook.service.note.NoteQueryManager;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.sso.facade.model.UserVO;

@Controller
@RequestMapping("/note")
public class NoteController {
	@Autowired
	private NoteTitleService	noteTitleService;
	@Autowired
	private NoteQueryManager	noteQueryService;
	@Autowired
	private SearchManager		searchManager;
	

	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult addNote(NoteTitle noteTitle, HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		NoteTitleVO noteTitleVO = noteTitleService.addNote(user, noteTitle);
		return blogforumResult.ok(noteTitleVO);
	}

	@RequestMapping(value = "/updateNote", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult updateNote(NoteVO note, HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		noteTitleService.updateNote(user, note);
		return blogforumResult.ok();
	}

	@RequestMapping(value = "/getNoteTitleList", method = RequestMethod.GET)
	@ResponseBody
	public blogforumResult getNoteTitleList(NoteTitle noteTitle, HttpServletRequest request,
						HttpServletResponse response) {
		UserVO user = (UserVO) request.getAttribute("user");
		Page<NoteTitleVO> pageNoteTitleVO = noteQueryService.queryNoteTitle(new Page<NoteTitle>(request, response),
							user, noteTitle.getNoteBookId());
		return blogforumResult.ok(pageNoteTitleVO);
	}

	@RequestMapping(value = "/getNoteBody", method = RequestMethod.GET)
	@ResponseBody
	public blogforumResult getNoteBody(NoteTitle noteTitle, HttpServletRequest request,
						HttpServletResponse response) {
		UserVO user = (UserVO) request.getAttribute("user");
		NoteBodyVO noteBodyVO = noteQueryService.queryNoteBody(user, noteTitle);
		return blogforumResult.ok(noteBodyVO);
	}

	@RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult deleteNote(String noteId, HttpServletRequest request) {
		UserVO user = (UserVO) request.getAttribute("user");
		NoteTitle noteTitle = noteTitleService.deleteNote(user, noteId);
		return blogforumResult.ok(noteTitle.getNoteBookId());

	}

	@RequestMapping(value = "/searchNote", method = RequestMethod.GET)
	@ResponseBody
	public blogforumResult searchNote(SearchNoteRequestVO requestVO, HttpServletRequest request,
						HttpServletResponse response) {
		UserVO user = (UserVO) request.getAttribute("user");
		requestVO.setUserId(user.getId());
		Page<NoteTitleVO> searchNote = searchManager.searchNote(requestVO);
		return blogforumResult.ok(searchNote);
	}
	
	
	
}
