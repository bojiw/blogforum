package com.blogforum.notebook.service.note.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.tools.BaseConverter;
import com.blogforum.common.tools.UUIDCreateUtils;
import com.blogforum.notebook.common.enums.IsDelFlagEnum;
import com.blogforum.notebook.common.enums.NoteErrorEnum;
import com.blogforum.notebook.common.exception.NoteBusinessException;
import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.dao.mapper.NoteBookMapper;
import com.blogforum.notebook.pojo.entity.NoteBook;
import com.blogforum.notebook.pojo.entity.NoteTitle;
import com.blogforum.notebook.pojo.vo.NoteBookVO;
import com.blogforum.notebook.service.CrudService;
import com.blogforum.notebook.service.note.NoteBookService;
import com.blogforum.notebook.service.note.NoteTitleService;
import com.blogforum.sso.facade.model.UserVO;

@Service
public class NoteBookServiceImpl extends CrudService<NoteBook> implements NoteBookService {
	@Autowired
	protected NoteBookMapper	noteBookMapper;

	@Autowired
	private NoteTitleService	noteTitleService;
	

	@Override
	public List<NoteBook> queryListByParentId(NoteBook noteBook) {
		List<NoteBook> noteBooks = noteBookMapper.queryListByParentId(noteBook);
		return noteBooks;
	}

	@Override
	public NoteBookVO addBook(UserVO user, String parentId, String name) {
		//组装参数
		NoteBook noteBook = new NoteBook();
		String id = UUIDCreateUtils.getUUID();
		noteBook.setId(id);
		noteBook.setParentId(parentId);
		noteBook.setName(name);
		noteBook.setUserId(user.getId());
		noteBook.setParentId(parentId);
		noteBook.setHaveNode(false);
		noteBook.setDelFlag(IsDelFlagEnum.N.getValue());
		//执行保存
		super.save(noteBook);
		//如果父节点不是0代表是有父节点 更新父节点有子节点状态
		if (!StringUtils.equals(parentId, "0")) {
			//根据父id查询父节点
			NoteBook noteBookCondition = new NoteBook(parentId);
			NoteBook parentNoteBook = super.getById(noteBookCondition);
			if (!parentNoteBook.getHaveNode()) {
				parentNoteBook.setHaveNode(true);
				super.update(parentNoteBook);
			}
		}
		//转换成前端要展示的vo 并且设置笔记数量为0
		BaseConverter<NoteBook, NoteBookVO> noteBookConverter = new BaseConverter<>();
		NoteBookVO noteBookVO = noteBookConverter.convert(noteBook, NoteBookVO.class);
		noteBookVO.setNoteCount(0);
		return noteBookVO;
	}

	@Override
	public NoteBookVO updateBook(String id, UserVO user, String name) {
		//通过ID查询对应的笔记本
		NoteBook bookCondition = new NoteBook(user.getId(), id, null);
		NoteBook noteBook = super.getById(bookCondition);
		if (null == noteBook) {
			throw new NoteBusinessException(NoteErrorEnum.NOT_NOTEBOOK);
		}
		//设置笔记本的名字并更新
		noteBook.setName(name);
		super.update(noteBook);
		//转换为前端需要的参数
		BaseConverter<NoteBook, NoteBookVO> noteBookConverter = new BaseConverter<>();
		NoteBookVO noteBookVO = noteBookConverter.convert(noteBook, NoteBookVO.class);
		return noteBookVO;
	}

	@Override
	public Boolean deleteBook(String noteBookId, String parentId, UserVO user) {
		//删除笔记这里需要考虑子笔记本和笔记的删除
		NoteBook bookCondition = new NoteBook(user.getId(), noteBookId, null);
		NoteBook noteBook = super.getById(bookCondition);
		//验证数据是否正常
		checkValue(noteBook,user,noteBookId);
		//删除并更新笔记本
		Boolean isNode = delNoteBookAndUpdate(noteBook,user);
		return isNode;
	}
	
	/**
	 * 效验数据 不可以有子笔记本或者子笔记
	 * @param noteBook
	 * @param user
	 * @param noteBookId
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	private void checkValue(NoteBook noteBook,UserVO user,String noteBookId){
		if (noteBook == null) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,new StringBuilder("找不到该笔记本!!!,noteBookId=").append(noteBookId).toString());
		}
		if (noteBook.getHaveNode()) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,new StringBuilder("该笔记本下有子笔记不可删除!!!,noteBookId=").append(noteBookId).toString());
		}
		NoteTitle title = new NoteTitle(user.getId(), noteBookId);
		//分页查询前20条记录
		Page<NoteTitle> notes = noteTitleService.queryList(new Page<NoteTitle>(), title);
		if (CollectionUtils.isNotEmpty(notes.getList())) {
			throw new NoteBusinessException(BizErrorEnum.ILLEGAL_PARAMETER,new StringBuilder("该笔记本下有笔记不可删除!!!,noteBookId=").append(noteBookId).toString());
		}
	}
	
	/**
	 * 删除笔记本 并且更新父节点是否有子节点 把更新结果返回
	 * @param noteBook
	 * @param user
	 * @return
	 * @author: wwd
	 * @time: 2017年12月2日
	 */
	private Boolean delNoteBookAndUpdate(NoteBook noteBook,UserVO user){
		noteBook.setDelFlag(IsDelFlagEnum.Y.getValue());
		super.delete(noteBook);
		//父笔记本是否有子笔记本
		Boolean isNode = true;
		//如果笔记本的父id不是0代表有父笔记本 判断父笔记本下是否有子笔记本 如果没有则把父笔记本的有子节点设置为false
		if (!StringUtils.equals(noteBook.getParentId(), "0")) {
			//通过父笔记本id看看是否能获取笔记本 如果没有代表父笔记本已经没有子节点了 设置为false
			NoteBook prevNoteBook = new NoteBook(user.getId(), noteBook.getParentId());
			List<NoteBook> noteBooks = queryListByParentId(prevNoteBook);
			if (CollectionUtils.isEmpty(noteBooks)) {
				NoteBook parent = new NoteBook(user.getId(), noteBook.getParentId(), null);
				NoteBook parentNoteBook = super.getById(parent);
				parentNoteBook.setHaveNode(false);
				super.update(parentNoteBook);
				isNode = false;
			}
		}
		return isNode;
	}
	

}
