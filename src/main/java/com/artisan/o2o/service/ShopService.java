package com.artisan.o2o.service;

import com.artisan.o2o.dto.ShopExcution;
import com.artisan.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExcution addService(Shop shop, InputStream shopFileInputStream, String fileName);
}
