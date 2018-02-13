package com.blogforum.notebook.facade.model;

import java.util.List;

public class ImageContextVO extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String				noteBodyId;
	private List<ImageString>	imageStrings;

	public String getNoteBodyId() {
		return noteBodyId;
	}

	public void setNoteBodyId(String noteBodyId) {
		this.noteBodyId = noteBodyId;
	}

	public List<ImageString> getImageStrings() {
		return imageStrings;
	}

	public void setImageStrings(List<ImageString> imageStrings) {
		this.imageStrings = imageStrings;
	}

}
