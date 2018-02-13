package com.blogforum.notebook.dao.mapper;

import java.util.List;

import com.blogforum.notebook.pojo.entity.NoteBook;

public interface NoteBookMapper extends CrudMapper<NoteBook> {
	
	/**
	 * 通过父笔记本id获取下面的笔记
	 * @param noteBook
	 * @return
	 * @author: wwd
	 * @time: 2017年11月12日
	 */
	List<NoteBook> queryListByParentId(NoteBook	noteBook);

}
