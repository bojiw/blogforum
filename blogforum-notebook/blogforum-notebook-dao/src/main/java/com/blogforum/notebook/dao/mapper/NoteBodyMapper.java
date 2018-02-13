package com.blogforum.notebook.dao.mapper;

import com.blogforum.notebook.pojo.entity.NoteBody;

public interface NoteBodyMapper extends CrudMapper<NoteBody> {

	/**
	 * 通过笔记标题id获取笔记内容
	 * @param noteBody
	 * @return
	 * @author: wwd
	 * @time: 2017年11月12日
	 */
	NoteBody getByNoteTitleId(NoteBody noteBody);
}
