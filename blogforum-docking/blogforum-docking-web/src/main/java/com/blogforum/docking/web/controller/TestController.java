package com.blogforum.docking.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.docking.service.mail.MailSend;
import com.blogforum.docking.service.sms.SmsSend;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Resource
	private MailSend simpleMailSend;
	@Resource
	private SmsSend verificationSmsSend;

	@RequestMapping("/mail")
	@ResponseBody
	public String testMail(){
		simpleMailSend.send("897136043@qq.com", "欢迎注册搏击用户", "验证码为", null);
		return "ok";
	}
	@RequestMapping("/sms")
	@ResponseBody
	public String testSmsl(){
		Map<String,Object> extended = new HashMap<>();
		//设置短信标签
		extended.put("signName", "博记系统");
		//设置短信模板
		extended.put("templateCode", "SMS_77240046");
		verificationSmsSend.send("13034687582", "{\"number\":\"1325\"}", extended);
		return "ok";
	}
}
