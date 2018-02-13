package com.blogforum.notebook.service.image.impl;

import java.util.List;
import java.util.regex.Matcher;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.docking.facade.model.ConverImageVO;
import com.blogforum.notebook.common.utils.ExpressionUtil;
import com.blogforum.notebook.facade.enums.NoteMsgExchangeNameEnum;
import com.blogforum.notebook.facade.enums.NoteMsgRouterKeyEnum;
import com.blogforum.notebook.pojo.entity.NoteBody;
import com.blogforum.notebook.service.image.ImageConver;
import com.blogforum.notebook.service.rabbitmq.producer.SendMqMessage;
import com.google.common.collect.Lists;

@Component
public class ImageConverImpl implements ImageConver {

	@Autowired
	private SendMqMessage sendMqMessage;

	@Override
	public void sendImageConver(NoteBody noteBody) {

		//1、效验参数并且做正则匹配
		Matcher srcs = checkValueAndGetMatching(noteBody);
		//效验不通过退出
		if (srcs == null) {
			return;
		}
		List<String> imageUrls = buildImageUrls(srcs);
		ConverImageVO converImageVO = new ConverImageVO();
		converImageVO.setImageUrls(imageUrls);
		converImageVO.setNoteBodyId(noteBody.getId());
		sendMqMessage.sendMsg(converImageVO, NoteMsgExchangeNameEnum.DIRECT_IMAGE_CONVER_STRING_DOCKING,
							NoteMsgRouterKeyEnum.KEY_IMAGE_CONVER_STRING_DOCKING);
	}

	/**
	 * 效验参数并且获取匹配的matcher
	 * 
	 * @return
	 * @author: wwd
	 * @time: 2017年12月10日
	 */
	private Matcher checkValueAndGetMatching(NoteBody noteBody) {
		//笔记内容为空不进行处理
		if (StringUtils.isEmpty(noteBody.getNoteBody())) {
			return null;
		}
		//通过正则表达式获取笔记中带有img标记的文字 为了准确性 先匹配img标签 再匹配src标签
		Matcher srcs = ExpressionUtil.getMatching(noteBody.getNoteBody(), "(src|SRC)=(\"|\')(.*?)(\"|\')");
		//如果没有则退出
		if (!srcs.find()) {
			return null;
		}
		return srcs;
	}

	/**
	 * 获取查到的正则表达式中的所有图片地址
	 * 
	 * @param srcs
	 * @return
	 * @author: wwd
	 * @time: 2017年12月10日
	 */
	private List<String> buildImageUrls(Matcher srcs) {
		//把找到的图片url放入到list中
		List<String> imageUrls = Lists.newArrayList();
		//因为前面效验的时候已经srcs.find()了 肯定有图片链接  不可以用while(srcs.find())做判断 不然第一个图片链接会没有
		Boolean isImg = true;
		while (isImg) {
			String str_src = srcs.group(3);
			imageUrls.add(str_src);
			isImg = srcs.find();
		}
		return imageUrls;
	}

}
