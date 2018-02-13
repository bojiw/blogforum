package com.blogforum.notebook.pojo.vo;

public class SearchNoteRequestVO extends SearchRequestVO {


	/**
	 * 请求笔记本的id
	 */
	private String	noteBookId;
	
	public String getNoteBookId() {
		return noteBookId;
	}

	public void setNoteBookId(String noteBookId) {
		this.noteBookId = noteBookId;
	}
}
