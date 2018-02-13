package com.blogforum.search.facade.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestQuerySearch extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6677465538489149935L;

	/**
	 * 服务名
	 */
	private String				serviceName;

	/**
	 * 查询关键字
	 */
	private String				keyword;

	/**
	 * 请求页数 默认查询所有
	 */
	private Integer				pageNo				= 0;

	/**
	 * 请求页数大小 默认查询所有
	 */
	private Integer				pageSize			= 0;

	/**
	 * 需要让哪些字段满足条件 如userid一定要是某个值
	 */
	private List<String>		filters				= new ArrayList<>();

	/**
	 * 查询字段 只获取要查询的字段信息
	 */
	private String[]			fields;

	/**
	 * 排序字段
	 */
	private List<SortField>		sortfields;

	/**
	 * 默认搜索域字段
	 */
	private String				defaultQueryField;

	/**
	 * 扩展字段
	 */
	private Map<String, Object>	parameter;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getFilters() {
		return filters;
	}

	public List<String> setFilters(String key, String value) {
		filters.add(new StringBuffer(key).append(":").append(value).toString());
		return filters;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public Map<String, Object> getParameter() {
		return parameter;
	}

	public void setParameter(Map<String, Object> parameter) {
		this.parameter = parameter;
	}

	public List<SortField> getSortfields() {
		return sortfields;
	}

	public void setSortfields(List<SortField> sortfields) {
		this.sortfields = sortfields;
	}

	public String getDefaultQueryField() {
		return defaultQueryField;
	}

	public void setDefaultQueryField(String defaultQueryField) {
		this.defaultQueryField = defaultQueryField;
	}

}
