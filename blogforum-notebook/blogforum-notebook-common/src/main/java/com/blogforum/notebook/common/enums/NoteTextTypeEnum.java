package com.blogforum.notebook.common.enums;

public enum NoteTextTypeEnum {

	/** 原创 */
	ORIGINAL("original", "原创"),
	
	/** 翻译*/
	TRANSLATE("translate","翻译"),
	
	/** 转载 */
	REPRINT("reprint", "转载");
	
	private String	value;
	private String	memo;

	private NoteTextTypeEnum(String	value,String memo) {
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
