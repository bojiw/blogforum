package com.blogforum.notebook.service.manager.note;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.pojo.vo.HistoryNoteVO;
import com.blogforum.sso.facade.model.UserVO;

public interface HistoryNoteManager {

	/**
	 * 分页查询笔记历史记录
	 * @param user
	 * @param noteBodyId
	 * @return
	 * @author: wwd
	 * @time: 2018年2月3日
	 */
	Page<HistoryNoteVO> queryHistoryNote(UserVO user, String noteBodyId);
	
	
	/**
	 * 还原历史记录
	 * 
	 * @author: wwd
	 * @time: 2018年2月3日
	 */
	void updateRestoreNote(UserVO user, String noteBodyId,String historyId,String noteTitleId);

}
