package o2o.com.artisan.o2o.dao;

import java.util.Date;

import com.artisan.o2o.dao.ShopDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.artisan.o2o.entity.Area;
import com.artisan.o2o.entity.PersonInfo;
import com.artisan.o2o.entity.Shop;
import com.artisan.o2o.entity.ShopCategory;

import o2o.com.artisan.o2o.BaseTest;

public class ShopDaoTest extends BaseTest {
	@Autowired
	ShopDao shopDao;

	@Test
	public void ShopDao() {

		Shop shop=new Shop();
		PersonInfo pi=new PersonInfo();
		pi.setUserId(1l);
		shop.setOwner(pi);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setShopName("林当铺");
		shop.setShopDesc("发财");
		shop.setPhone("199029192");
		Area area=new Area();
		area.setAreaName("关羽");
        shop.setArea(area);

		int a=shopDao.insertShop(shop);
		System.out.println(a);

	}

	@Test
	public void updateShop() {

       Shop shop=new Shop();
       shop.setShopId(12l);
       Area area =new Area();
       area.setAreaId(1);
       shop.setArea(area);
       shop.setPhone("18334532843");
       shop.setShopDesc("机遇和挑战");
       int b=shopDao.updateShop(shop);
       System.out.println(b);


	/*	  // shop_id 不可更新 personInfo不可更新
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        // 模拟更新 shop_id=5的记录 。 因为目前数据库中只有一条shop_id=5的数据
        shop.setShopId(5L);

        // 将area_id更新成2
        area.setAreaId(2);
        // 为了防止因外键约束，导致更新异常，同时也能验证更新方法没有问题
        // 新增一条测试数据将shopCategoryId更新为2
        shopCategory.setShopCategoryId(2L);

        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("ArtisanUP");
        shop.setShopDesc("ArtisanDescUP");
        shop.setShopAddr("NanJingUP");
        shop.setPhone("123456UP");
        shop.setShopImg("/xxx/xxx/UP");
        shop.setPriority(66);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("Waring UP");
	*//*	int g=shopDao.updateShop(shop);*//*
		System.out.println("修改成功");*/
	}

}
