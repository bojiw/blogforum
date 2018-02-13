package com.blogforum.docking.facade.enums;

public enum DockingMsgExchangeNameEnum {

	/**图片转文字交换机*/
	DIRECT_IMAGE_CONVER_STRING_DOCKING("direct_image_conver_string_docking", "图片转文字交换机");
	

	private String	name;
	private String	memo;

	private DockingMsgExchangeNameEnum(String name, String memo) {
		this.name = name;
		this.memo = memo;
	}

	public DockingMsgExchangeNameEnum getQueueByName(String name) {
		for (DockingMsgExchangeNameEnum queueNameEnum : values()) {
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
