package com.blogforum.notebook.facade.enums;

public enum NoteMsgExchangeNameEnum {

	/**图片转文字交换机*/
	DIRECT_IMAGE_CONVER_STRING_DOCKING("direct_image_conver_string_docking", "图片转文字交换机");

	private String	name;
	private String	memo;

	private NoteMsgExchangeNameEnum(String name, String memo) {
		this.name = name;
		this.memo = memo;
	}

	public NoteMsgExchangeNameEnum getQueueByName(String name) {
		for (NoteMsgExchangeNameEnum queueNameEnum : values()) {
			if (queueNameEnum.name.equals(name)) {
				return queueNameEnum;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
