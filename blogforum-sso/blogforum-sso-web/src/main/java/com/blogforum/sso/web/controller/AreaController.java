package com.blogforum.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogforum.sso.pojo.entity.Area;
import com.blogforum.sso.service.userservice.AreaService;

@RestController
public class AreaController {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/save")
	public String save(){
		Area area = new Area();
		area.setName("中国");
		area.setParentId(1);
		areaService.insert(area);
		return "ok";
	}
}
