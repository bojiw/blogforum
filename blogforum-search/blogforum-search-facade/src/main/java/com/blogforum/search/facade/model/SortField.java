package com.blogforum.search.facade.model;

public class SortField {

	/**
	 * 要排序的字段
	 */
	private String	sortField;

	/**
	 * 降序还是升序 true代表升序
	 */
	private boolean	sortflag;

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public boolean getSortflag() {
		return sortflag;
	}

	public void setSortflag(boolean sortflag) {
		this.sortflag = sortflag;
	}

}
