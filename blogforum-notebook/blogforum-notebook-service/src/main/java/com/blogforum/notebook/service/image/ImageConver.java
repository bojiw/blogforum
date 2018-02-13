package com.blogforum.notebook.service.image;

import com.blogforum.notebook.pojo.entity.NoteBody;

public interface ImageConver {

	/**
	 * 把文档中的图片发消息给docking系统做转换处理
	 * @param noteBody
	 * @author: wwd
	 * @time: 2017年12月10日
	 */
	void sendImageConver(NoteBody noteBody);
	
}
