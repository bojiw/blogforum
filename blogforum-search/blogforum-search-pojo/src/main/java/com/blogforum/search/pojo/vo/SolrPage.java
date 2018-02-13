package com.blogforum.search.pojo.vo;
/**
 * solr分页对象
 * @author wwd
 *
 */
public class SolrPage {

	/**
	 * 从第几条开始
	 */
	private int	start	= 0;
	/**
	 * 获取多少条 空代表获取全部
	 */
	private int	rows;
	
	public SolrPage() {
	}

	public  SolrPage(Integer pageNo,Integer pageSize){
		//如果请求页数不为0 代表获取全部 使用默认值
		if (pageNo > 0) {
			this.start = (pageNo - 1)  * pageSize;
			this.rows = pageSize;
		}
	}
	

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
