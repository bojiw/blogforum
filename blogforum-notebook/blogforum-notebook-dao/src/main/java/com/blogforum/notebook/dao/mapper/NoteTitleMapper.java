package com.blogforum.notebook.dao.mapper;

import com.blogforum.notebook.pojo.entity.NoteTitle;

public interface NoteTitleMapper extends CrudMapper<NoteTitle> {

	/**
	 * 获取笔记本下有多少笔记
	 * @param noteBookId
	 * @return
	 * @author: wwd
	 * @time: 2017年10月25日
	 */
	int countByNoteBookId(String noteBookId);

}
