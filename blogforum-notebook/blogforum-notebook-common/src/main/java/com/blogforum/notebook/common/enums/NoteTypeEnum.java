package com.blogforum.notebook.common.enums;

public enum NoteTypeEnum {

	/** 普通富文本笔记 */
	SIMPLENOTE("simplenote", "普通富文本笔记"),
	/** markdown格式笔记 */
	MARKDOWNNOTE("markdownnote", "markdown格式笔记");
	private String	value;
	private String	memo;

	private NoteTypeEnum(String	value,String memo) {
		this.value = value;
		this.memo = memo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
