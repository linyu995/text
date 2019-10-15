package o2o.com.artisan.o2o.service;

import com.artisan.o2o.dto.ShopExcution;
import com.artisan.o2o.entity.Area;
import com.artisan.o2o.entity.PersonInfo;
import com.artisan.o2o.entity.Shop;
import com.artisan.o2o.entity.ShopCategory;
import com.artisan.o2o.enums.ShopStateEnums;
import com.artisan.o2o.service.ShopService;
import o2o.com.artisan.o2o.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

public class ShopServiceTest extends BaseTest {

    public static final Logger log=LoggerFactory.getLogger(ShopService.class);

    @Autowired
    ShopService shopService;

    @Test
    public void shopServiceTest(){

        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        personInfo.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("咖啡店Improve");
        shop.setShopDesc("小工匠的咖啡店Improve");
        shop.setShopAddr("NanJing-Improve");
        shop.setPhone("9876553");
        shop.setPriority(99);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(ShopStateEnums.CHECK.getState());
        shop.setAdvice("审核中Improve");

        File shopFile = new File("D:/practice-work/o2o/image/no-taskList.jpg");
        String shopFiles=shopFile.getName();
        ShopExcution se = null;
        InputStream ins = null;
        try {
            ins = new FileInputStream(shopFile);
            se = shopService.addService(shop, ins, shopFiles);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(ShopStateEnums.CHECK.getState(), se.getState());
    }

}
