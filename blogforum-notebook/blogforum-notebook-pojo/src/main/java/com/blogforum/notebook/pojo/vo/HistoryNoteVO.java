package com.blogforum.notebook.pojo.vo;

import java.util.Date;

import com.blogforum.notebook.pojo.entity.DataEntity;

public class HistoryNoteVO extends DataEntity<HistoryNoteVO> {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * 编号
	 */
	private String				id;
	/**
	 * 笔记内容
	 */
	private String				noteBody;

	/**
	 * md格式笔记内容
	 */
	private String				mdNoteBody;
	/**
	 * 附件路径
	 */
	private String				enclosure;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String				delFlag;

	/**
	 * 扩展参数
	 */
	private String				extjson;

	/**
	 * 标签,用;隔开
	 */
	private String				label;
	/**
	 * 内容类型 是原创还是转载还是翻译 NoteTextTypeEnum
	 */
	private String				textType;

	/**
	 * 笔记头部表id
	 */
	private String				noteTitleId;

	/**
	 * 图片文字
	 */
	private String				imageContext;

	/**
	 * 用户id
	 */
	private String				userId;

	/**
	 * 笔记标题名
	 */
	private String				noteTitleName;

	/**
	 * 为该笔记的历史记录
	 */
	private String				noteBodyId;

	/**
	 * 最后一次更新时间
	 */
	private Date				lastDate;

	/**
	 * 笔记开头纯文本内容
	 */
	private String				noteContext;
	/**
	 * 笔记类型
	 */
	private String				type;
	/**
	 * 笔记本id
	 */
	private String				noteBookId;
	/**
	 * 笔记本名字
	 */
	private String				noteBookName;

	public HistoryNoteVO() {
	}

	public HistoryNoteVO(String userId, String noteBodyId) {
		init(userId, null, noteBodyId);
	}

	public HistoryNoteVO(String userId, String id, String noteBodyId) {
		init(userId, id, noteBodyId);
	}

	private void init(String userId, String id, String noteBodyId) {
		this.userId = userId;
		this.id = id;
		this.noteBodyId = noteBodyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	public String getMdNoteBody() {
		return mdNoteBody;
	}

	public void setMdNoteBody(String mdNoteBody) {
		this.mdNoteBody = mdNoteBody;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getExtjson() {
		return extjson;
	}

	public void setExtjson(String extjson) {
		this.extjson = extjson;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTextType() {
		return textType;
	}

	public void setTextType(String textType) {
		this.textType = textType;
	}

	public String getNoteTitleId() {
		return noteTitleId;
	}

	public void setNoteTitleId(String noteTitleId) {
		this.noteTitleId = noteTitleId;
	}

	public String getImageContext() {
		return imageContext;
	}

	public void setImageContext(String imageContext) {
		this.imageContext = imageContext;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoteTitleName() {
		return noteTitleName;
	}

	public void setNoteTitleName(String noteTitleName) {
		this.noteTitleName = noteTitleName;
	}

	public String getNoteBodyId() {
		return noteBodyId;
	}

	public void setNoteBodyId(String noteBodyId) {
		this.noteBodyId = noteBodyId;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getNoteContext() {
		return noteContext;
	}

	public void setNoteContext(String noteContext) {
		this.noteContext = noteContext;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNoteBookId() {
		return noteBookId;
	}

	public void setNoteBookId(String noteBookId) {
		this.noteBookId = noteBookId;
	}

	public String getNoteBookName() {
		return noteBookName;
	}

	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}

}
