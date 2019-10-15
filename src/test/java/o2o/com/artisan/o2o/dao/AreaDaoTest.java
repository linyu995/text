package o2o.com.artisan.o2o.dao;

import static org.junit.Assert.assertEquals;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.artisan.o2o.dao.AreaDao;
import com.artisan.o2o.entity.Area;

import o2o.com.artisan.o2o.BaseTest;

public class AreaDaoTest extends BaseTest {

    @Autowired
    AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 插入了2条测试数据,期望list中有2条
        assertEquals(2, areaList.size());
        // SQL中按照权重排序,上海priority 99 ,期望第一条数据是 上海
        System.out.println(areaList.get(0));

    }
}
