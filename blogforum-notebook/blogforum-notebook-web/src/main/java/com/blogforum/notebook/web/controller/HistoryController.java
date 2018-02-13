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
import com.blogforum.notebook.pojo.vo.HistoryNoteVO;
import com.blogforum.notebook.service.manager.note.HistoryNoteManager;
import com.blogforum.sso.facade.model.UserVO;

@RequestMapping("/history")
@Controller
public class HistoryController {
	
	@Autowired
	private HistoryNoteManager	historyNoteManager;

	@RequestMapping(value = "/getHistoryNote", method = RequestMethod.GET)
	@ResponseBody
	public blogforumResult getHistoryNote(String noteBodyId, HttpServletRequest request,
						HttpServletResponse response) {
		UserVO user = (UserVO) request.getAttribute("user");
		Page<HistoryNoteVO> historyNotes = historyNoteManager.queryHistoryNote(user, noteBodyId);
		return blogforumResult.ok(historyNotes);
	}
	
	@RequestMapping(value = "/restoreNote", method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult restoreNote(String noteBodyId,String historyId,String noteTitleId,HttpServletRequest request,
						HttpServletResponse response){
		
		UserVO user = (UserVO) request.getAttribute("user");
		historyNoteManager.updateRestoreNote(user, noteBodyId, historyId,noteTitleId);
		return blogforumResult.ok();
	}
	
	
}
