package com.blogforum.notebook.facade.enums;

public enum NoteMsgRouterKeyEnum {

	/** 默认的路由key一般用来给广播交换机使用 */
	DEFAULT_ROUTER_KEY("default_router_key","默认的路由key一般用来给广播交换机使用"),
	
	/** 图片转文字的routerkey */
	KEY_IMAGE_CONVER_STRING_DOCKING("key_image_conver_string_docking","图片转文字的routerkey");
	

	private String	name;
	private String	memo;

	private NoteMsgRouterKeyEnum(String name, String memo) {
		this.name = name;
		this.memo = memo;
	}

	public NoteMsgRouterKeyEnum getQueueByName(String name) {
		for (NoteMsgRouterKeyEnum queueNameEnum : values()) {
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
