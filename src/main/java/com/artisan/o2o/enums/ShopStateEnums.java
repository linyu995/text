package com.artisan.o2o.enums;

public enum ShopStateEnums {

    CHECK(0, "审核中"), OFFLINE(1, "非法店铺"), SUCESS(2, "操作成功"), PASS(2, "审核通过"), INNER_ERROR(-1001, "操作失败"), NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP_INFO(-1003, "传入了空的信息");

    private int state;
    private String info;

    ShopStateEnums(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public static String getName(int state) {
        for (ShopStateEnums c : ShopStateEnums.values()) {
            if (c.getState() == state) {
                return c.info;
            }
        }
        return null;
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
