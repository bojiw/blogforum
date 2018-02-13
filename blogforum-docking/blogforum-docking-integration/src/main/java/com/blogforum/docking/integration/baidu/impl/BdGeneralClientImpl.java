package com.blogforum.docking.integration.baidu.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.aip.ocr.AipOcr;
import com.blogforum.docking.integration.baidu.BdGeneralClient;

public class BdGeneralClientImpl implements BdGeneralClient {

	private static final Logger	logger	= LoggerFactory.getLogger(BdGeneralClientImpl.class);

	private String				APP_ID;
	private String				API_KEY;
	private String				SECRET_KEY;
	private int					CONN_TIME_OUT;
	private int					SOCKET_TIME_OUT;

	@Override
	public JSONArray getImageToJson(String url) {
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(CONN_TIME_OUT);
		client.setSocketTimeoutInMillis(SOCKET_TIME_OUT);

		// 调用接口
		try {
			JSONObject response3 = client.generalUrl(url, new HashMap<String, String>());
			Map<String, Object> map = response3.toMap();
			Object errorCode = map.get("error_code");
			if (errorCode != null) {
				logger.error(new StringBuffer("调用百度图片转文字接口失败:url=").append(url).append(",errorCode=").append(errorCode)
									.append(",error_msg=").append(map.get("error_msg")).toString());
				return null;
			}
			JSONArray jsonArray = response3.getJSONArray("words_result");
			return jsonArray;
		} catch (Exception e) {
			logger.error(new StringBuffer("调用百度图片转文字接口失败:url=").append(url).toString(),e);
		}

		return null;
	}


	public void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}


	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}


	public void setSECRET_KEY(String sECRET_KEY) {
		SECRET_KEY = sECRET_KEY;
	}


	public void setCONN_TIME_OUT(int cONN_TIME_OUT) {
		CONN_TIME_OUT = cONN_TIME_OUT;
	}


	public void setSOCKET_TIME_OUT(int sOCKET_TIME_OUT) {
		SOCKET_TIME_OUT = sOCKET_TIME_OUT;
	}

}
