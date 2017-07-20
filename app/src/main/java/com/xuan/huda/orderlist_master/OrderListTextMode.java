package com.xuan.huda.orderlist_master;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23 0023.
 */

public class OrderListTextMode {

    /**
     * content : [{"order":"iphone7 128G 深空灰","price":"50.00"},{"order":"iPhone6s 64G 深空灰","price":"50.00"}]
     * flag : 1
     * orderid : 758258
     * title : iphone
     * totalMoney : 100.00
     */

    private int flag;
    private String orderid;
    private String title;
    private String totalMoney;
    private List<ContentBean> content;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * order : iphone7 128G 深空灰
         * price : 50.00
         */

        private String order;
        private String price;

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
