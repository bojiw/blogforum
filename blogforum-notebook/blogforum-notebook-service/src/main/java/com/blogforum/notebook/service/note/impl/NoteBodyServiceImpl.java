package com.blogforum.notebook.service.note.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.notebook.dao.mapper.NoteBodyMapper;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.service.CrudService;
import com.blogforum.notebook.service.note.NoteBodyService;

@Service
public class NoteBodyServiceImpl extends CrudService<NoteBody> implements NoteBodyService {

	@Autowired
	private NoteBodyMapper noteBodyMapper;

	@Override
	public NoteBody getByNoteTitleId(NoteBody noteBody) {
		return noteBodyMapper.getByNoteTitleId(noteBody);
	}

}
