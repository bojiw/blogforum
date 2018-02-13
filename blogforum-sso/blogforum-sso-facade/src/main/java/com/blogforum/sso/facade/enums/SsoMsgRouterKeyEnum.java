package com.blogforum.sso.facade.enums;

public enum SsoMsgRouterKeyEnum {

	/** 默认的路由key一般用来给广播交换机使用 */
	DEFAULT_ROUTER_KEY("default_router_key","默认的路由key一般用来给广播交换机使用"),
	
	/**创建用户时执行的消息队列*/
	SSO_INITUSER_QUEUE_KEY("sso_init_user_queue_key.#", "创建用户时执行的消息队列");

	private String	name;
	private String	memo;

	private SsoMsgRouterKeyEnum(String name, String memo) {
		this.name = name;
		this.memo = memo;
	}

	public SsoMsgRouterKeyEnum getQueueByName(String name) {
		for (SsoMsgRouterKeyEnum queueNameEnum : values()) {
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
