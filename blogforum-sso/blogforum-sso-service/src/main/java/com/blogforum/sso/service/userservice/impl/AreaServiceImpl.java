package com.blogforum.sso.service.userservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.sso.dao.mapper.AreaMapper;
import com.blogforum.sso.pojo.entity.Area;
import com.blogforum.sso.service.userservice.AreaService;
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public void insert(Area area) {
		areaMapper.save(area);

	}

}
