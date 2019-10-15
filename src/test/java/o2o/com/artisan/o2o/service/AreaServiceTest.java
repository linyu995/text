package o2o.com.artisan.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.artisan.o2o.entity.Area;
import com.artisan.o2o.service.AreaService;

import o2o.com.artisan.o2o.BaseTest;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest{

	 @Autowired
	 AreaService areaService;

	 @Test
	 public void ServiceTest() {


	 	areaService.queryService();
	 }



}
