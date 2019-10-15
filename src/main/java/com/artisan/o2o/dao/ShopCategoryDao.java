package com.artisan.o2o.dao;

import com.artisan.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {

       List<ShopCategory> queryShopCategoryList(@Param("shopCategoryCondition") ShopCategory shopCategory);

}
