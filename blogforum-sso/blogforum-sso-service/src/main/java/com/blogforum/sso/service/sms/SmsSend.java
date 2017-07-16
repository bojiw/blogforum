package com.blogforum.sso.service.sms;

import java.util.Map;

/**
 * 短信发送接口
 * @author wwd
 *
 */
public interface SmsSend {
	
	/**
	 * 短信发送
	 * @param phoneNumbers 发送人手机
	 * @param templateParam 模板中的变量替换JSON串
	 * @param extended 扩展参数
	 */
	public void send(String phoneNumbers, String templateParam,Map<String,Object> extended);

}
