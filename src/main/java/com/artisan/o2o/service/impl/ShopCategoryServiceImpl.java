package com.artisan.o2o.service.impl;

import com.artisan.o2o.dao.ShopCategoryDao;
import com.artisan.o2o.entity.ShopCategory;
import com.artisan.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    ShopCategoryDao shopCategoryDao;

    public List<ShopCategory> queryCategoryService(ShopCategory shopCategory) {

        return shopCategoryDao.queryShopCategoryList(shopCategory);
    }
}
