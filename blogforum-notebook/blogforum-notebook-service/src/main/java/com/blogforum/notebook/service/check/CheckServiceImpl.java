package com.blogforum.notebook.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.notebook.common.exception.NoteBusinessException;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.service.note.NoteBodyService;
import com.blogforum.sso.facade.model.UserVO;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private NoteBodyService noteBodyService;
	
	@Override
	public NoteBody checkNote(NoteTitle noteTitle, UserVO user, String noteTitleId) {
		if (noteTitle == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,
								new StringBuilder("没有该笔记!,noteTitleId:").append(noteTitleId).toString());
		}
		NoteBody bodyCondition = new NoteBody(user.getId(), noteTitleId);
		NoteBody noteBody = noteBodyService.getByNoteTitleId(bodyCondition);
		if (noteBody == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,
								new StringBuilder("系统异常,没有对应的笔记内容!,noteTitleId:").append(noteTitleId).toString());
		}
		return noteBody;
	}

}
