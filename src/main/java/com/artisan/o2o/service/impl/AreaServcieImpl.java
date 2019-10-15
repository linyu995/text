package com.artisan.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artisan.o2o.dao.AreaDao;
import com.artisan.o2o.entity.Area;
import com.artisan.o2o.service.AreaService;
@Service
public class AreaServcieImpl implements AreaService {
   
	@Autowired
	AreaDao areaDao;
	
	public List<Area> queryService() {
		
		return areaDao.queryArea();
	}

}
