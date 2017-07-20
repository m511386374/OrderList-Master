package com.xuan.huda.orderlist_master;

/**
 * Created by Administrator on 2017/1/23 0023.
 */

public class OrderListMode {
    private int type;//item条目类型
    private String orderId;//订单号
    private String storeName;//商店名
    private String goodsName;//商品名
    private String money;//商品当前金额额
    private String totalMoney;//商品总金额
    private int flag;//订单类型
    private int img;//商品图片

    /**
     *  content条目用
     * @param goodsName
     * @param money
     */
    public OrderListMode(int type,String goodsName, String money,int img) {
        this.type = type;
        this.goodsName = goodsName;
        this.money = money;
        this.img = img;
    }

    /**
     *  title标头条目用
     * @param type
     * @param orderId
     * @param storeName
     */
    public OrderListMode(int type, String orderId, String storeName) {
        this.type = type;
        this.orderId = orderId;
        this.storeName = storeName;
    }

    /**
     *  标底用
     * @param type
     * @param totalMoney
     * @param flag
     */
    public OrderListMode(int type, String totalMoney, int flag) {
        this.type = type;
        this.totalMoney = totalMoney;
        this.flag = flag;
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
