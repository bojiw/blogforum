package com.blogforum.notebook.interfaces.search.impl;

import com.blogforum.common.model.Result;
import com.blogforum.notebook.interfaces.search.SolrServiceFacadeClient;
import com.blogforum.notebook.interfaces.utils.BaseInvocation;
import com.blogforum.notebook.interfaces.utils.ServiceTemplate;
import com.blogforum.search.facade.model.RequestQuerySearch;
import com.blogforum.search.facade.model.SearchPage;
import com.blogforum.search.facade.service.SolrServiceFacade;

public class SolrServiceFacadeClientImpl implements SolrServiceFacadeClient {
	
	private SolrServiceFacade solrServiceFacade;

	@Override
	public SearchPage query(final RequestQuerySearch request) {
		return ServiceTemplate.invoke(new BaseInvocation<SearchPage>() {

			@Override
			public Result<SearchPage> execute() {
				return solrServiceFacade.query(request);
			}
		});
	}

	public void setSolrServiceFacade(SolrServiceFacade solrServiceFacade) {
		this.solrServiceFacade = solrServiceFacade;
	}
	

}
