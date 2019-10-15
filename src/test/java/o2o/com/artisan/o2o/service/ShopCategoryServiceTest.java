package o2o.com.artisan.o2o.service;
import com.artisan.o2o.entity.ShopCategory;
import com.artisan.o2o.service.ShopCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryServiceTest {

    @Autowired
    ShopCategoryService shopCategoryService;

    @Test
    public void ShopCategoryServcie(){
        ShopCategory shopCategory=new ShopCategory();
        List<ShopCategory> shopCategoryList= shopCategoryService.queryCategoryService(shopCategory);
        Assert.assertEquals(2,shopCategoryList.size());
        for(ShopCategory shopCategory1:shopCategoryList){
            System.out.println(shopCategory1.getShopCategoryName());
        }

    }
}
