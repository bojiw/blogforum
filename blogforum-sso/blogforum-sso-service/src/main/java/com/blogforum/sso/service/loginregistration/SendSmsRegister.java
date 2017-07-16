package com.blogforum.sso.service.loginregistration;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.constant.ServiceConstant;
import com.blogforum.sso.service.sms.SmsSend;

@Component
public class SendSmsRegister extends AbstractLoginRegister {
	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SmsSend verificationSmsSend;

	@Override
	public blogforumResult execute(LoginRegisterContext context) {
		User user = context.getUser();
		checkSmsValue(user,"0000");
		//获取验证码
		String verificationCode = getVerificationCodeAndSetExRedis(user.getIphone());
		//设置需要短信模板变量为生成的验证码
		StringBuffer templateParam = new StringBuffer();
		templateParam.append("{\"number\":\"").append(verificationCode).append("\"}");
		verificationSmsSend.send(user.getIphone(),templateParam.toString(),buildExtended());
		logger.info(MessageFormat.format("成功发送短信 手机号为:{0}，验证码为：{1}", user.getIphone(),verificationCode));
		return blogforumResult.ok();
	}
	
	//填充扩展函数
	private Map<String, Object> buildExtended(){
		Map<String,Object> extended = new HashMap<>();
		//设置短信标签
		extended.put("signName", ServiceConstant.signName);
		//设置短信模板
		extended.put("templateCode", ServiceConstant.templateCode);
		return extended;
	}

}
