package com.artisan.o2o.dao;

import com.artisan.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopDao {
   int insertShop(Shop shop);
   int updateShop(Shop shop);
   Shop selectShopById(long ShopId);
}
