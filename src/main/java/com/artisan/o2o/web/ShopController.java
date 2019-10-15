package com.artisan.o2o.web;

import com.artisan.o2o.dto.ShopExcution;
import com.artisan.o2o.entity.Area;
import com.artisan.o2o.entity.PersonInfo;
import com.artisan.o2o.entity.Shop;
import com.artisan.o2o.entity.ShopCategory;
import com.artisan.o2o.enums.ShopStateEnums;
import com.artisan.o2o.service.AreaService;
import com.artisan.o2o.service.ShopCategoryService;
import com.artisan.o2o.service.ShopService;
import com.artisan.o2o.util.HttpServletRequestUtil;
import com.artisan.o2o.util.VerifyCodeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopController {

    public static final Logger log= LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService shopServive;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/registshop", method =RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String,Object> modelMap=new HashMap<String, Object>();
        /**
        * 将json转化为实体类
        * */
        ObjectMapper mapper=new ObjectMapper();
        Shop shop=new Shop();
        String shopStr=HttpServletRequestUtil.getString(request,"shopStr");
        try{
            mapper.readValue(shopStr,Shop.class);
        }catch (Exception e){
         log.debug("Exception:{}",e.getMessage());
         modelMap.put("success",false);
         modelMap.put("emg",e.getMessage());
        }

        if(!VerifyCodeUtil.verifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMsg","验证码不正确");
        }
        /**
         * 图片的上传
         */
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new  CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartRequest= (MultipartHttpServletRequest) request;
            shopImg= (CommonsMultipartFile) multipartRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("msg","图片不能为空");
        }

        if (shop!=null&&shopImg!=null){

            PersonInfo personInfo=new PersonInfo();
            personInfo.setUserId(1L);
            shop.setOwner(personInfo);

            ShopExcution se = null;
            try {
                se=shopServive.addService(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                if(se.getState()== ShopStateEnums.CHECK.getState()){
                    modelMap.put("success",true);
                    modelMap.put("ermsg","注册成功");
                }else{
                    modelMap.put("success",false);
                    modelMap.put("errmsg",se.getInfo());
                }
            }catch (Exception e){
                log.debug("exception:{}",e.getMessage());
                e.printStackTrace();
                modelMap.put("success", false);
                modelMap.put("errMsg", "addShop Error");
            }
        }else{

            modelMap.put("success",false);
            modelMap.put("msg","请输入店铺信息");

        }
        return modelMap;
    }


        @RequestMapping(value = "/shopoperation", method = RequestMethod.GET)
        public String shopOperation() {
            return "shop/shopoperation";
        }

    /**
     * 商铺分类以及地区
     * @return
     */

    @RequestMapping(value="/getshopinitinfo",method=RequestMethod.GET)
    @ResponseBody
        public Map<String,Object> getshopinitinfo(){
            Map<String,Object> modelMap=new HashMap<String, Object>();
            try {
                /**
                 * 获取商品分类
                 */
               List<ShopCategory> shopCategoryList= shopCategoryService.queryCategoryService(new ShopCategory());
                /**
                 * 获取地区
                  */
               List<Area> areaList= areaService.queryService();
                modelMap.put("success",true);
               /* modelMap.put("shopCategoryList",shopCategoryList);*/
                modelMap.put("areaList",areaList);
            }catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("error",e.getMessage());
            }

           return modelMap;

        }


}
