package com.blogforum.notebook.common.enums;

public enum IsDelFlagEnum {
	
	/**删除标记*/
	Y("Y","删除标记"),
	/**不删除标记*/
	N("N","不删除标记");
	private String	value;
	private String	chinese;

	private IsDelFlagEnum(String value, String chinese) {
		this.value = value;
		this.chinese = chinese;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	
	
	

}
