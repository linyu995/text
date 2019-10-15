package com.artisan.o2o.util;

import com.mysql.jdbc.log.LogFactory;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

    public static File CommonsMultipartFile(CommonsMultipartFile cfile) {
        /**
         *
         * 难点
         */
        File file = null;
        try {
            file = new File(cfile.getOriginalFilename());
            cfile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static String generateThumbnails(InputStream ins, String destPath, String fileName) {
        String relativeAddr = null;
        try {
            String randomFileName = generateRandomFileName();
            String fileExtensionName = getFileExtensionName(fileName);
            /**
             * 校验destPaeh 文件是否存在
             */
            validateDestPath(destPath);
            /**
             * 获取扩展名
             */
            relativeAddr = destPath + randomFileName + fileExtensionName;
            String basePath = FileUtil.getImgBasePath();
            /**
             * 创建file文件；
             */
            File destFile = new File(basePath + relativeAddr);
            Thumbnails.of(ins).size(500, 500).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(FileUtil.getWaterMarkFile()), 0.25f).outputQuality(0.8).toFile(destFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建水印图片失败：" + e.toString());
        }
        /**
         * 返回文件名
         */
        return relativeAddr;
    }
    /**
     * 验证是否destfile是否存在
     * @param targetAddr
     */
    private static void validateDestPath(String targetAddr) {
    String realFileParentPath=FileUtil.getImgBasePath()+targetAddr;
    File dirPath =new File(realFileParentPath);
    if(!dirPath.exists()){
        dirPath.mkdirs();
    }
    }


    /**
     * 获取文件的名字
     *
     * @return
     */
    private static String generateRandomFileName() {
        Random random = new Random();
        int rand = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        String pattern;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String date = df.format(new Date());
        String fileName = rand + date;
        return fileName;
    }

    /**
     * 获取文件的扩展名,如:.jsp,.jpg等
     *
     * @param file
     * @return
     */
    private static String getFileExtensionName(String fileName) {
        String extensionName = fileName.substring(fileName.lastIndexOf("."));
        return extensionName;
    }


}
