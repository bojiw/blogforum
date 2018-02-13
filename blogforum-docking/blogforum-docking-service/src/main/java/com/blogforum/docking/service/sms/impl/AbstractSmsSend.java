package com.blogforum.docking.service.sms.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.blogforum.docking.common.exception.DockingBusinessException;
import com.blogforum.docking.service.sms.SmsSend;
@Service
public abstract class AbstractSmsSend implements SmsSend  {

	/**初始化acsClien需要参数不需要修改*/
	@Value("${sms.regionId}")
	protected String regionId;
	
	 /**阿里大于提供的AK*/
	@Value("${sms.accessKeyId}")
	protected String accessKeyId;
	@Value("${sms.accessKeySecret}")
	protected String accessKeySecret;
	
	/**产品名称:云通信短信API产品,开发者无需替换*/
	@Value("${sms.product}")
	protected String product;
	
	/**产品域名,开发者无需替换*/
	@Value("${sms.domain}")
	protected String domain;
	
	
    /**初始化acsClient,暂不支持region化*/
    protected IAcsClient acsClient = null;
    /**
     * 使用spring的后置处理 在所有bean实例化以后执行  不然读取不到上面的参数
     * 
     * @author: wwd
     * @time: 2017年12月3日
     */
    @PostConstruct
    public void init() {
    	try {
    		IClientProfile profile =DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
    		this.acsClient = new DefaultAcsClient(profile);
			DefaultProfile.addEndpoint(regionId, regionId, product, domain);
		} catch (ClientException e) {
			throw new DockingBusinessException("初始化acsClient失败，AbstractSmsSend",e);
		}
	}
    

}
