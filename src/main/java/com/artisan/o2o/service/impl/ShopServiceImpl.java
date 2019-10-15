package com.artisan.o2o.service.impl;

import com.artisan.o2o.ShopOperationException;
import com.artisan.o2o.dao.ShopDao;

import com.artisan.o2o.dto.ShopExcution;
import com.artisan.o2o.entity.Shop;
import com.artisan.o2o.enums.ShopStateEnums;
import com.artisan.o2o.service.ShopService;
import com.artisan.o2o.util.FileUtil;
import com.artisan.o2o.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author user
 */
@Service
public class ShopServiceImpl implements ShopService {

    public static final Logger log= LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private ShopDao shopDao;

    @Transactional
    public ShopExcution addService(Shop shop, InputStream shopImgInputStream, String fileName) {
        /**
         * 1.shop 为空
         * 2.状态设置为审核状态
         * 3.返回值是审核状态
         * 4.判断审核情况
         * 5.addShop 不明白
         * 6.更新店铺没明白
         * 7.为什么都用抛出异常，不是返回枚举的结果
         * 8.shopImgInputStream一直报错读取不到文件
         */
        if(shop==null){
            return  new ShopExcution(ShopStateEnums.NULL_SHOP_INFO);
        }

          shop.setEnableStatus(0);
          shop.setCreateTime(new Date());
          shop.setLastEditTime(new Date());


        int effectedNum=shopDao.insertShop(shop);

        if(effectedNum<=0){
            throw new ShopOperationException("创建店铺失败");
         }else{
            if(shopImgInputStream!=null){
                try{
                    /**
                     * 这步没看明白
                     */
                    addShopImg(shop, shopImgInputStream, fileName);

                }catch (Exception e){
                    log.debug("addShopImg error:",e.getMessage());
                    throw new ShopOperationException("addShopImg error:"+e.getMessage());
                }
                /**
                 * 更新店铺
                 */
                effectedNum=shopDao.updateShop(shop);
                if(effectedNum<=0){
                    log.debug("updateShop error {} ", "更新店铺失败");
                    throw new ShopOperationException("updateShop error");
                }

            }
       }
       return new ShopExcution(ShopStateEnums.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
          String imgPath= FileUtil.getShopImagePath(shop.getShopId());

        String relativeAddr= ImageUtil.generateThumbnails(shopImgInputStream,imgPath,fileName);

          shop.setShopImg(relativeAddr);

    }
}
