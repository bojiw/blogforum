package com.blogforum.notebook.service.note.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.tools.BaseConverter;
import com.blogforum.common.tools.UUIDCreateUtils;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;
import com.blogforum.notebook.common.exception.NoteBusinessException;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.dao.mapper.NoteTitleMapper;
import com.blogforum.notebook.pojo.entity.HistoryNote;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteTitleVO;
import com.blogforum.notebook.pojo.vo.NoteVO;
import com.blogforum.notebook.service.CrudService;
import com.blogforum.notebook.service.image.ImageConver;
import com.blogforum.notebook.service.note.HistoryNoteService;
import com.blogforum.notebook.service.note.NoteBodyService;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.sso.facade.model.UserVO;

@Service
public class NoteTitleServiceImpl extends CrudService<NoteTitle> implements NoteTitleService {

	@Autowired
	private NoteTitleMapper	noteTitleMapper;

	@Autowired
	private NoteBodyService	noteBodyService;
	
	@Autowired
	private HistoryNoteService historyNoteService;
	
	/**发送图片转文字消息*/
	@Autowired
	private ImageConver			imageConver;
	
	@Override
	public int countByNoteBookId(String noteBookId) {
		return noteTitleMapper.countByNoteBookId(noteBookId);
	}

	@Override
	public NoteTitleVO addNote(UserVO user, NoteTitle noteTitle) {
		//保存笔记标题
		noteTitle.setDelFlag(IsDelFlagEnum.N.getValue());
		noteTitle.setUserId(user.getId());
		noteTitle.setId(UUIDCreateUtils.getUUID());
		super.save(noteTitle);
		BaseConverter<NoteTitle, NoteTitleVO> converter = new BaseConverter<>();
		NoteTitleVO noteTitleVO = converter.convert(noteTitle, NoteTitleVO.class);
		//保存笔记内容
		NoteBody noteBody = new NoteBody();
		noteBody.setId(UUIDCreateUtils.getUUID());
		noteBody.setDelFlag(IsDelFlagEnum.N.getValue());
		noteBody.setNoteTitleId(noteTitle.getId());
		noteBody.setLabel(noteTitle.getNoteBookName());
		noteBody.setUserId(user.getId());
		noteBodyService.save(noteBody);
		return noteTitleVO;
	}

	@Override
	public void updateNote(UserVO user, NoteVO note) {
		NoteTitle title = new NoteTitle(user.getId(), note.getNoteTitleId(), null);
		//获取笔记
		NoteTitle noteTitle = super.getById(title);
		//效验参数
		NoteBody noteBody = checkValue(noteTitle, user, note.getNoteTitleId());
		//保存历史记录
		addHistory(noteBody,noteTitle);
		//保存内容
		updateTitleAndBody(note, noteTitle, noteBody);
	}

	/**
	 * 参数效验 效验通过则返回对应的笔记内容
	 * 
	 * @param noteTitle
	 * @param user
	 * @param note
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	private NoteBody checkValue(NoteTitle noteTitle, UserVO user, String noteTitleId) {
		if (noteTitle == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,
								new StringBuilder("没有该笔记!,noteTitleId:").append(noteTitleId).toString());
		}
		NoteBody bodyCondition = new NoteBody(user.getId(), noteTitleId);
		NoteBody noteBody = noteBodyService.getByNoteTitleId(bodyCondition);
		if (noteBody == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,
								new StringBuilder("系统异常,没有对应的笔记内容!,noteTitleId:").append(noteTitleId).toString());
		}
		return noteBody;
	}

	/**
	 * 保存历史笔记
	 * @param noteBody
	 * @author: wwd
	 * @time: 2018年2月3日
	 */
	private void addHistory(NoteBody noteBody,NoteTitle noteTitle){
		//如果笔记内容为空则不保存
		if (StringUtils.isBlank(noteBody.getNoteBody())) {
			return;
		}
		HistoryNote historyNote = new HistoryNote(noteBody,noteTitle);
		historyNoteService.save(historyNote);
	}
	
	
	
	/**
	 * 更新笔记标题内容和笔记内容
	 * 
	 * @param noteTitle
	 * @param noteBody
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	private void updateTitleAndBody(NoteVO note, NoteTitle noteTitle, NoteBody noteBody) {
		noteTitle.setNoteTitle(note.getNoteTitle());
		noteTitle.setNoteContext(note.getNoteContext());
		super.update(noteTitle);
		noteBody.setNoteBody(note.getNoteBody());
		noteBody.setMdNoteBody(note.getMdNoteBody());
		noteBody.setTextType(note.getTextType());
		noteBody.setLabel(note.getLabel());
		noteBody.setNoteTitleName(note.getNoteTitle());
		noteBodyService.update(noteBody);
		imageConver.sendImageConver(noteBody);
	}

	@Override
	public NoteTitle deleteNote(UserVO user, String noteTitleId) {
		NoteTitle titleCondition = new NoteTitle(user.getId(), noteTitleId, null);
		NoteTitle noteTitle = super.getById(titleCondition);
		//效验参数并返回noteBody
		NoteBody noteBody = checkValue(noteTitle, user, noteTitleId);
		//设置笔记为删除标记
		noteTitle.setDelFlag(IsDelFlagEnum.Y.getValue());
		super.delete(noteTitle);
		noteBody.setDelFlag(IsDelFlagEnum.Y.getValue());
		noteBodyService.delete(noteBody);
		NoteTitle noteTitleCondition = new NoteTitle(user.getId(), noteTitle.getNoteBookId());
		Page<NoteTitle> noteTitles = super.queryList(new Page<NoteTitle>(), noteTitleCondition);
		if (CollectionUtils.isEmpty(noteTitles.getList())) {
			
		}
		return noteTitle;
	}

}
