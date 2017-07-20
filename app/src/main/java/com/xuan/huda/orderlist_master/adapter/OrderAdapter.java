package com.xuan.huda.orderlist_master.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xuan.huda.orderlist_master.R;
import com.xuan.huda.orderlist_master.mode.OrderMode;

import java.util.List;

/**
 * Created by Administrator on 2017/1/24 0024.
 */

public class OrderAdapter extends BaseMultiItemQuickAdapter<OrderMode,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public OrderAdapter(List<OrderMode> data) {
        super(data);
        addItemType(OrderMode.CONTENT_ITEM_VIEW, R.layout.item_order_content);
        addItemType(OrderMode.TITLE_ITEM_VIEW, R.layout.item_order_title);

        addItemType(OrderMode.FOOT_ITEM_VIEW, R.layout.item_order_foot);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderMode item) {

        switch (helper.getItemViewType()){

            case OrderMode.TITLE_ITEM_VIEW:
                Log.d("dd==",item.getOrderId());
                helper.setText(R.id.tv_itemOrder_titleOrderId, "订单编号："+item.getOrderId());
                helper.setText(R.id.tv_itemOrder_titleStore, "商户名称："+item.getStoreName());

                helper.addOnClickListener(R.id.tv_itemOrder_titleStore);
                break;

            case OrderMode.CONTENT_ITEM_VIEW:
                Log.d("ccc==",item.getGoodsName());
                helper.setText(R.id.tv_itemOrder_contentName, item.getGoodsName());
                helper.setText(R.id.tv_itemOrder_contentColor, item.getMoney());

                helper.addOnClickListener(R.id.itemOrder_contentRoot);
                break;

            case OrderMode.FOOT_ITEM_VIEW:
                helper.setText(R.id.tv_itemOrder_footMoney, "应付金额："+item.getTotalMoney());
                if (item.getFlag()==1){
                    helper.setText(R.id.tv_itemOrder_footBtn,"付款");
                }else if (item.getFlag()==2){
                    helper.setText(R.id.tv_itemOrder_footBtn,"取消");
                }else if (item.getFlag()==3){
                    helper.setText(R.id.tv_itemOrder_footBtn,"完结");
                }

                helper.addOnClickListener(R.id.tv_itemOrder_footBtn);
                break;
        }
    }
}
