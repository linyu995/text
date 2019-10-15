package com.artisan.o2o.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URLDecoder;

public class FileUtil {


    public static final Logger log= LoggerFactory.getLogger(FileUtil.class);

    public static final  String separator=System.getProperty("file.separator");

    public static String  getImgBasePath(){

        String osName=System.getProperty("os.name");
        String basePath= "";
        if(osName.toLowerCase().startsWith("win")){
             basePath="D:/practice-work/o2o";
        }else{
             basePath="/home/artisan/o2o/image";
        }

          basePath=basePath.replace("/",separator);
          log.debug("message:{}",basePath);
          return  basePath;
    }

    public static String getShopImagePath(long shopId) {
        String shopImgPath = "/upload/item/shopImage/" + shopId + "/";
        shopImgPath = shopImgPath.replace("/", separator);
        log.debug("shopImgPath: {}", shopImgPath);
        return shopImgPath;
    }

    public static File getWaterMarkFile() {
        String basePath = FileUtil.getImgBasePath();
        String waterMarkImg = basePath + "/watermark/watermark.png";
        waterMarkImg = waterMarkImg.replace("/", separator);
        log.debug("waterMarkImg path: {}", waterMarkImg);
        return new File(waterMarkImg);

    }
}
