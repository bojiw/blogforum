package com.blogforum.docking.integration.note;

import com.blogforum.notebook.facade.model.ImageContextVO;

public interface NoteBodyServerFacadeClient {

	
	/**
	 * 更新笔记内容图片文字
	 * @param imageTextVO
	 * @author: wwd
	 * @time: 2017年12月16日
	 */
	public Boolean updateImageText(ImageContextVO imageContextVO );
}
