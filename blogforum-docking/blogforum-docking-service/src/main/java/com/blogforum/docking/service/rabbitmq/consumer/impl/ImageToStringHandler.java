package com.blogforum.docking.service.rabbitmq.consumer.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

import com.alibaba.fastjson.JSON;
import com.blogforum.docking.facade.model.ConverImageVO;
import com.blogforum.docking.integration.baidu.BdGeneralClient;
import com.blogforum.docking.integration.note.NoteBodyServerFacadeClient;
import com.blogforum.docking.service.rabbitmq.consumer.Handler;
import com.blogforum.notebook.facade.model.ImageContextVO;
import com.blogforum.notebook.facade.model.ImageString;
import com.blogforum.notebook.facade.model.Location;
import com.google.common.collect.Lists;

public class ImageToStringHandler implements Handler {
	private static final Logger	logger	= LoggerFactory.getLogger(ImageToStringHandler.class);


	private BdGeneralClient				bdGeneralClient;

	private NoteBodyServerFacadeClient	noteBodyServerFacadeClient;

	@Override
	public void doHandler(Message message, String messageInfo) {

		ConverImageVO converImageVO = JSON.parseObject(messageInfo, ConverImageVO.class);
		List<String> imageUrls = converImageVO.getImageUrls();
		ImageContextVO imageContextVO = new ImageContextVO();
		imageContextVO.setNoteBodyId(converImageVO.getNoteBodyId());
		List<ImageString> imageStrings = Lists.newArrayList();
		
		for (String url : imageUrls) {
			//通过百度api获取图片的文字信息
			JSONArray jsonArray = bdGeneralClient.getImageToJson(url);
			try{
				//因为百度API有限制不能调用太过频繁 采用2秒调用一次
				TimeUnit.MILLISECONDS.sleep(2000);
			}catch(Exception e){
				logger.error("停止线程出现异常",e);
			}
			if (jsonArray == null) {
				continue;
			}
			for (int i = 0; i < jsonArray.length(); i++) {
				//拼接图片内容
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				ImageString word = buildImageInfo(jsonObject);
				imageStrings.add(word);
			}
		}
		imageContextVO.setImageStrings(imageStrings);
		noteBodyServerFacadeClient.updateImageText(imageContextVO);

	}

	/**
	 * 从百度传过来的json 拼接图片内容
	 * 
	 * @param jsonObject
	 * @return
	 * @author: wwd
	 * @time: 2017年12月16日
	 */
	private ImageString buildImageInfo(JSONObject jsonObject) {
		ImageString word = new ImageString();
		String object = jsonObject.getString("words");
		word.setWords(object);
		JSONObject baiduLocation = jsonObject.getJSONObject("location");
		Location location = new Location();
		location.setTop(baiduLocation.getInt("top"));
		location.setLeft(baiduLocation.getInt("left"));
		location.setWidth(baiduLocation.getInt("width"));
		location.setHeight(baiduLocation.getInt("height"));
		word.setLocation(location);
		return word;
	}


	public void setBdGeneralClient(BdGeneralClient bdGeneralClient) {
		this.bdGeneralClient = bdGeneralClient;
	}

	public void setNoteBodyServerFacadeClient(NoteBodyServerFacadeClient noteBodyServerFacadeClient) {
		this.noteBodyServerFacadeClient = noteBodyServerFacadeClient;
	}

}
