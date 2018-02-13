package com.blogforum.docking.facade.model;

import java.util.List;

public class ConverImageVO extends SuperModel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1321611926151473690L;

	/**
	 * 笔记内容id
	 */
	private String				noteBodyId;

	private List<String>		imageUrls;

	public String getNoteBodyId() {
		return noteBodyId;
	}

	public void setNoteBodyId(String noteBodyId) {
		this.noteBodyId = noteBodyId;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

}
