package com.blogforum.notebook.service.note;

import java.util.List;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteBodyVO;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.sso.facade.model.UserVO;

public interface NoteQueryManager {

	/**
	 * 分页查询笔记本下的笔记标题
	 * 
	 * @param page
	 * @param userVO
	 * @param noteBookId
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	public Page<NoteTitleVO> queryNoteTitle(Page<NoteTitle> page, UserVO user, String noteBookId);

	/**
	 * 查询笔记本
	 * 
	 * @param user
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	List<NoteBookVO> queryNoteBook(UserVO user, String parentId);
	
	
	/**
	 * 提供可搜索笔记本
	 * 
	 * @param user
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	List<NoteBookVO> getSearchNoteBook(UserVO user);

	/**
	 * 查询笔记内容
	 * @param user
	 * @param noteTitle
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	NoteBodyVO queryNoteBody(UserVO user, NoteTitle noteTitle);

}
