package com.blogforum.notebook.service.facade.note.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.model.ErrorContext;
import com.blogforum.common.model.Result;
import com.blogforum.notebook.facade.model.ImageContextVO;
import com.blogforum.notebook.facade.note.NoteBodyServerFacade;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.service.note.NoteBodyService;

public class NoteBodyServerFacadeImpl implements NoteBodyServerFacade {

	@Autowired
	private NoteBodyService noteBodyService;

	@Override
	public Result<Boolean> updateImageText(ImageContextVO imageContextVO) {
		Result<Boolean> result = new Result<>();
		result.setSuccess(true);
		NoteBody noteBodyCondition = new NoteBody();
		noteBodyCondition.setId(imageContextVO.getNoteBodyId());
		NoteBody noteBody = noteBodyService.getById(noteBodyCondition);
		if (noteBody == null) {
			result.setErrorContext(new ErrorContext(BizErrorEnum.ILLEGAL_PARAMETER,
								"笔记不存在,noteBodyId=" + imageContextVO.getNoteBodyId()));
			return result;
		}
		if (CollectionUtils.isNotEmpty(imageContextVO.getImageStrings())) {
			noteBody.setImageContext(JSON.toJSONString(imageContextVO.getImageStrings()));
		}
		noteBodyService.update(noteBody);
		return result;

	}

}
