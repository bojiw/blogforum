package com.blogforum.notebook.service.check;

import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.sso.facade.model.UserVO;

public interface CheckService {

	NoteBody checkNote(NoteTitle noteTitle, UserVO user, String noteTitleId);
	
}
