package com.blogforum.notebook.facade.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BaseSO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360049315527145536L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
