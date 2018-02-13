package com.blogforum.search.service.manager.query.Impl;

import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.service.book.BookSolrQueryService;
import com.blogforum.search.service.manager.query.QueryHandler;

public class BookQueryHandlerImpl implements QueryHandler {

	private BookSolrQueryService bookSolrQueryService;
	
	@Override
	public SearchPage query(RequestQuerySearch request) {
		
		SearchPage bookVO = bookSolrQueryService.defaultQuery(request);
		return bookVO;
	}

	public void setBookSolrQueryService(BookSolrQueryService bookSolrQueryService) {
		this.bookSolrQueryService = bookSolrQueryService;
	}

}
