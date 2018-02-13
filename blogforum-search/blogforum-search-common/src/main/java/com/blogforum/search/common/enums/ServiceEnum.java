package com.blogforum.search.common.enums;

import org.apache.commons.lang3.StringUtils;

public enum ServiceEnum {

	NOTE_QUERY("note_search", "noteQueryHandler", "笔记solr库查询服务"), 
	BOOK_QUERY("book_search", "bookQueryHandler","笔记本solr库查询服务");

	private String	serverName;

	private String	serverBean;

	private String	memo;

	ServiceEnum(String serverName, String serverBean, String memo) {
		this.serverName = serverName;
		this.serverBean = serverBean;
		this.memo = memo;
	}

	
	public static String getServerBeanByServerName(String serverName){
		
		for (ServiceEnum serviceEnum : values()) {
			if (StringUtils.equals(serviceEnum.getServerName(), serverName)) {
				return serviceEnum.serverBean;
			}
		}
		return "";
	}
	
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerBean() {
		return serverBean;
	}

	public void setServerBean(String serverBean) {
		this.serverBean = serverBean;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}