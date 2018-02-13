package com.blogforum.docking.facade.model;

import java.util.Map;

public class SuperModel extends BaseVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8702723685377476456L;
	/** 扩展属性 */
	private Map<String, Object>	extended;

	public Map<String, Object> getExtended() {
		return extended;
	}

	public void setExtended(Map<String, Object> extended) {
		this.extended = extended;
	}
	

}
