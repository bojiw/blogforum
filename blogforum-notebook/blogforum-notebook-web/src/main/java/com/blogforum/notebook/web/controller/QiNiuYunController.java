package com.blogforum.notebook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.blogforumResult;
import com.qiniu.util.Auth;

/**
 * 七牛云存储类
 * @author wwd
 *
 */
@Controller
@RequestMapping("/qiniuyun")
public class QiNiuYunController {
	
	@RequestMapping("/upload")
	@ResponseBody
	public blogforumResult upload(){
		//生成七牛云上传token
		String accessKey = "QODCgNX4F6Udt02f4_0qHF2WfkGNxBnx0UcXsw8k";
		String secretKey = "NLAftTu5qIpkTbbkwXjfJAHb_fL6_QDi0Ay2WRKB";
		String bucket = "blogforum";

		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return blogforumResult.ok(upToken);
	}

	
	public static void main(String[] args) {
		String accessKey = "QODCgNX4F6Udt02f4_0qHF2WfkGNxBnx0UcXsw8k";
		String secretKey = "NLAftTu5qIpkTbbkwXjfJAHb_fL6_QDi0Ay2WRKB";
		String bucket = "blogforum";

		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		System.out.println(upToken);
	}


}
