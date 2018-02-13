package com.blogforum.notebook.service.note;

import java.util.List;

import com.blogforum.notebook.pojo.entity.NoteBook;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.service.BaseService;
import com.blogforum.sso.facade.model.UserVO;

public interface NoteBookService extends BaseService<NoteBook> {
	
	/**
	 * 根据父笔记本id和用户id获取笔记本
	 * @param noteBook
	 * @return
	 * @author: wwd
	 * @time: 2017年11月11日
	 */
	List<NoteBook> queryListByParentId(NoteBook noteBook);
	
	
	/**
	 * 新增笔记本
	 * @param userId
	 * @param parentId
	 * @param name
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	NoteBookVO addBook(UserVO user,String parentId,String name);
	
	
	/**
	 * 更新笔记本
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	NoteBookVO updateBook(String id,UserVO user,String name);
	
	/**
	 * 删除笔记本
	 * @param id
	 * @param parentId
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	Boolean deleteBook(String noteBookId, String parentId,UserVO user);
	

}
