package com.blogforum.notebook.service.manager.search;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.SearchNoteRequestVO;

public interface SearchManager {
	
	/**
	 * 搜索笔记
	 * @param requestVO
	 * @return
	 * @author: wwd
	 * @time: 2018年1月21日
	 */
	Page<NoteTitleVO> searchNote(SearchNoteRequestVO requestVO);
	

}
