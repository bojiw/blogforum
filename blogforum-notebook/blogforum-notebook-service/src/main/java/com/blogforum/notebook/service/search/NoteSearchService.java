package com.blogforum.notebook.service.search;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.SearchNoteRequestVO;

public interface NoteSearchService {

	/**
	 * 搜索笔记内容
	 * @param searchRequestVO 搜索请求对象
	 * @author: wwd
	 * @time: 2018年1月21日
	 */
	Page<NoteTitleVO> searchNotePage(SearchNoteRequestVO searchNoteVO);
}
