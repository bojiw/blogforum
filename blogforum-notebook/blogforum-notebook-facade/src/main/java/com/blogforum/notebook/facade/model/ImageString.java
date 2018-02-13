package com.blogforum.notebook.facade.model;

public class ImageString extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/** 图片文字内容 */
	private String				words;
	/** 坐标 */
	private Location			location;

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
