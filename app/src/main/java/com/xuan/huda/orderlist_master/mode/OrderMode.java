package com.xuan.huda.orderlist_master.mode;

import com.chad.library.adapter.base.entity.MultiItemEntity;


/**
 * 订单列表实体类
 */
public class OrderMode implements MultiItemEntity {

    public static final int TITLE_ITEM_VIEW = 1;
    public static final int CONTENT_ITEM_VIEW = 2;
    public static final int FOOT_ITEM_VIEW = 3;
    public int type;
    private String orderId;//订单号
    private String storeName;//商店名
    private String goodsName;//商品名
    private String money;//商品当前金额额
    private String totalMoney;//商品总金额
    private int flag;//订单类型

    public OrderMode(int type, String orderId, String storeName, String goodsName, String money, String totalMoney, int flag) {
        this.type = type;
        this.orderId = orderId;
        this.storeName = storeName;
        this.goodsName = goodsName;
        this.money = money;
        this.totalMoney = totalMoney;
        this.flag = flag;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
