package com.blogforum.search.web.controller.note;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.service.book.BookSolrQueryService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookSolrQueryService bookSolrQueryService;
	
	@RequestMapping("/getbook")
	@ResponseBody
	public blogforumResult getNoteBooks(String keyword,String fields,String filterkey,String filterValue,Integer pageNo,Integer pageSize,HttpServletRequest request) {
		RequestQuerySearch querySearch = new RequestQuerySearch();
		querySearch.setPageNo(pageNo);
		querySearch.setPageSize(pageSize);
		querySearch.setKeyword(keyword);
		
		SearchPage defaultQuery = bookSolrQueryService.defaultQuery(querySearch);
		return blogforumResult.ok(defaultQuery);
	}
}
