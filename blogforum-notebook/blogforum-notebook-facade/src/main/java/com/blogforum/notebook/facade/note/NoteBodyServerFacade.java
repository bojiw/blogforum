package com.blogforum.notebook.facade.note;

import com.blogforum.common.model.Result;
import com.blogforum.notebook.facade.model.ImageContextVO;

public interface NoteBodyServerFacade {

	
	/**
	 * 更新笔记内容图片文字
	 * @param imageTextVO
	 * @author: wwd
	 * @time: 2017年12月16日
	 */
	public Result<Boolean> updateImageText(ImageContextVO imageContextVO );
	
}
