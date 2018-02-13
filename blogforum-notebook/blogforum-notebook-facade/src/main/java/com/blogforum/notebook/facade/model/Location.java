package com.blogforum.notebook.facade.model;

public class Location extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5761041628211704219L;
	private Integer				top;
	private Integer				left;
	private Integer				width;
	private Integer				height;

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}
