package o2o.com.artisan.o2o.dao;

import com.artisan.o2o.dao.ShopCategoryDao;
import com.artisan.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopCategoryTest {

    @Autowired
    ShopCategoryDao shopCategoryDao;

   @Test
  public void ShopCateGory(){
       ShopCategory shopCategory = new ShopCategory();
       List<ShopCategory> categoryList = shopCategoryDao.queryShopCategoryList(shopCategory);
       Assert.assertEquals(2, categoryList.size());
       for (ShopCategory shopCategory2 : categoryList) {
           System.out.println(shopCategory2);
       }


  }

}
