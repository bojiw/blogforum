package com.blogforum.notebook.common.enums;

public enum NoteErrorEnum {
	
	/**笔记内容不存在*/
	NOT_NOTEBODY("901","笔记内容不存在"),
	/**笔记标题不存在*/
	NOT_NOTETITLE("902","笔记标题不存在"),
	/**笔记本不存在*/
	NOT_NOTEBOOK("903","笔记本不存在");
	
	private String	code;
	private String	msg;

	private NoteErrorEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public NoteErrorEnum getBizByCode(String code){
		for (NoteErrorEnum ssoBizError : values()) {
			if (ssoBizError.code.equals(code)) {
				return ssoBizError;
			}
		}
		return null;
	}
	public NoteErrorEnum getBizByMsg(String msg){
		for (NoteErrorEnum ssoBizError : values()) {
			if (ssoBizError.msg.equals(msg)) {
				return ssoBizError;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
