package com.blogforum.notebook.service.note;

import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.NoteVO;
import com.blogforum.notebook.service.BaseService;
import com.blogforum.sso.facade.model.UserVO;

public interface NoteTitleService extends BaseService<NoteTitle> {

	/**
	 * 获取笔记本下有多少笔记
	 * 
	 * @param noteBookId
	 * @return
	 * @author: wwd
	 * @time: 2017年10月25日
	 */
	int countByNoteBookId(String noteBookId);

	/**
	 * 添加笔记内容
	 * 
	 * @param user
	 * @param noteTitle
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	NoteTitleVO addNote(UserVO user, NoteTitle noteTitle);

	
	/**
	 * 更新笔记
	 * @param user
	 * @param note
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	void updateNote(UserVO user, NoteVO note);
	
	
	/**
	 * 删除对应笔记
	 * @param user
	 * @param noteId
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	NoteTitle deleteNote(UserVO user,String noteTitleId);

}
