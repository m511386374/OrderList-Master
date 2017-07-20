package com.xuan.huda.orderlist_master;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13 0013.
 */

public class AdapterD extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context mContext;
    public List<OrderListMode> mList;
    private final int HEAD = 0x001;
    private final int ITEM = 0x002;
    private final int FOOT = 0x003;

    public AdapterD(Context context, List<OrderListMode> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEAD:
                return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_many_d_title, parent, false));
            case ITEM:
                return new ContentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_many_d_content, parent, false));
            case FOOT:
                return new FootHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_many_d_foot, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEAD) {
            TitleHolder viewHolder = (TitleHolder) holder;
            viewHolder.tv_itemd_titleOrderId.setText("订单编号："+mList.get(position).getOrderId());
            viewHolder.tv_itemd_titleStore.setText("商户名称："+mList.get(position).getStoreName());

        } else if (getItemViewType(position) == ITEM) {
            ContentHolder viewHolder = (ContentHolder) holder;
            viewHolder.tv_itemd_contentName.setText(mList.get(position).getGoodsName()+"");
            viewHolder.tv_itemd_contentColor.setText(mList.get(position).getMoney()+"");

        } else if (getItemViewType(position) == FOOT) {
            FootHolder viewHolder = (FootHolder) holder;
            viewHolder.tv_itemd_footMoney.setText("应付总金额："+mList.get(position).getTotalMoney());
            if (mList.get(position).getFlag()==1){
                viewHolder.tv_itemd_footBtn.setText("付款");
            }else if (mList.get(position).getFlag()==2){
                viewHolder.tv_itemd_footBtn.setText("取消");
            }else {
                viewHolder.tv_itemd_footBtn.setText("完结");
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (mList.get(position).getType()){
            case 1:
                return HEAD;

            case 2:
                return ITEM;

            case 3:
                return FOOT;

            default:
                return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class TitleHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemd_titleRoot;
        private TextView tv_itemd_titleOrderId, tv_itemd_titleStore;

        public TitleHolder(View view) {
            super(view);
            itemd_titleRoot = (LinearLayout) view.findViewById(R.id.itemd_titleRoot);
            tv_itemd_titleOrderId = (TextView) view.findViewById(R.id.tv_itemd_titleOrderId);
            tv_itemd_titleStore = (TextView) view.findViewById(R.id.tv_itemd_titleStore);
        }
    }

    public class ContentHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemd_contentRoot;
        private TextView tv_itemd_contentName, tv_itemd_contentColor;

        public ContentHolder(View view) {
            super(view);
            itemd_contentRoot = (LinearLayout) view.findViewById(R.id.itemd_contentRoot);
            tv_itemd_contentName = (TextView) view.findViewById(R.id.tv_itemd_contentName);
            tv_itemd_contentColor = (TextView) view.findViewById(R.id.tv_itemd_contentColor);
        }
    }

    public class FootHolder extends RecyclerView.ViewHolder{
        private LinearLayout itemd_footRoot;
        private TextView tv_itemd_footMoney, tv_itemd_footBtn;

        public FootHolder(View view) {
            super(view);
            itemd_footRoot = (LinearLayout) view.findViewById(R.id.itemd_footRoot);
            tv_itemd_footMoney = (TextView) view.findViewById(R.id.tv_itemd_footMoney);
            tv_itemd_footBtn = (TextView) view.findViewById(R.id.tv_itemd_footBtn);
        }
    }

}
