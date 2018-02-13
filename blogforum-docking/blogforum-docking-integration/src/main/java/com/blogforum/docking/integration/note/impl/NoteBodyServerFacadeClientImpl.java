package com.blogforum.docking.integration.note.impl;

import com.blogforum.common.model.Result;
import com.blogforum.docking.integration.note.NoteBodyServerFacadeClient;
import com.blogforum.docking.integration.utils.BaseInvocation;
import com.blogforum.docking.integration.utils.ServiceTemplate;
import com.blogforum.notebook.facade.model.ImageContextVO;
import com.blogforum.notebook.facade.note.NoteBodyServerFacade;

public class NoteBodyServerFacadeClientImpl implements NoteBodyServerFacadeClient{

	private NoteBodyServerFacade noteBodyServerFacade;
	
	@Override
	public Boolean updateImageText(final ImageContextVO imageContextVO) {
		return ServiceTemplate.invoke(new BaseInvocation<Boolean>() {
			@Override
			public Result<Boolean> execute() {
				return noteBodyServerFacade.updateImageText(imageContextVO);
			}
		});
		
	}

	public void setNoteBodyServerFacade(NoteBodyServerFacade noteBodyServerFacade) {
		this.noteBodyServerFacade = noteBodyServerFacade;
	}
	
	

}
