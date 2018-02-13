package com.blogforum.search.facade.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends SuperVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 999811217081284309L;
	private int pageNo; // 当前页码
	private int pageSize;// 分页大小
	private long count;// 总记录数
	private int countNum;//总页数

	private boolean firstPage = false;// 是否是第一页
	private boolean lastPage = false;// 是否是最后一页

	//返回对象
	private List<Object> list = new ArrayList<Object>();

	//扩展函数
	private Map<String,Object> params=new HashMap<String, Object>();

	public SearchPage(int pageNo,int pageSize,long count) {
		
		this.pageSize = pageSize;
		this.count = count;
		this.pageNo = pageNo;
        if (count <= 0 ) {
        	this.countNum = 1;
        	this.firstPage = true;
        	this.lastPage = true;
        }else {
        	countNum = (int) Math.ceil((double) count / pageSize);
        	if (countNum == pageNo) {
        		
        		this.lastPage = true;
			}
        	if (pageNo == 1) {
        		this.firstPage = true;
			}
		}
        
	}
	
	
	
	
	public int getCountNum() {
		return countNum;
	}




	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}




	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
	
	


}
