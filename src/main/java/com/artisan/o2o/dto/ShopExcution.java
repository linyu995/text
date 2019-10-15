package com.artisan.o2o.dto;

import com.artisan.o2o.entity.PersonInfo;
import com.artisan.o2o.entity.Shop;
import com.artisan.o2o.enums.ShopStateEnums;

import java.util.List;

/**
 * DTO 类 ShopExcution
 */
public class ShopExcution {
   private int state;
   private String info;
   private int count;
   private Shop shop;
   private List<Shop> shoplist;


   public ShopExcution(ShopStateEnums shopStateEnums){
       this.state=shopStateEnums.getState();
       this.info=shopStateEnums.getInfo();
   }

   public ShopExcution(ShopStateEnums shopStateEnums,Shop shop){
       this.state=shopStateEnums.getState();
       this.info=shopStateEnums.getInfo();
       this.shop=shop;
   }

   public ShopExcution(ShopStateEnums shopStateEnums,List<Shop> shoplist){
      this.state=shopStateEnums.getState();
      this.info=shopStateEnums.getInfo();
      this.shoplist=shoplist;
   }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
