package com.blogforum.sso.service.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.blogforum.sso.common.exception.SSOBusinessException;
import com.blogforum.sso.service.constant.ServiceConstant;

public abstract class AbstractSmsSend implements SmsSend {

	/**阿里大鱼短信发送类*/
	protected SendSmsRequest request = new SendSmsRequest();
    /**初始化acsClient,暂不支持region化*/
    protected IClientProfile profile = DefaultProfile.getProfile(ServiceConstant.regionId, ServiceConstant.accessKeyId, ServiceConstant.accessKeySecret);
    protected IAcsClient acsClient = new DefaultAcsClient(profile);
    public AbstractSmsSend() {
    	try {
			DefaultProfile.addEndpoint(ServiceConstant.regionId, ServiceConstant.regionId, ServiceConstant.product, ServiceConstant.domain);
		} catch (ClientException e) {
			throw new SSOBusinessException("初始化acsClient失败，AbstractSmsSend");
		}
	}
    

}
