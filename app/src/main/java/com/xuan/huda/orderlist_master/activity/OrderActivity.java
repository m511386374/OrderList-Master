package com.xuan.huda.orderlist_master.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xuan.huda.orderlist_master.AdapterD;
import com.xuan.huda.orderlist_master.GsonUtil;
import com.xuan.huda.orderlist_master.MainActivity;
import com.xuan.huda.orderlist_master.OrderListMode;
import com.xuan.huda.orderlist_master.OrderListTextMode;
import com.xuan.huda.orderlist_master.R;
import com.xuan.huda.orderlist_master.adapter.OrderAdapter;
import com.xuan.huda.orderlist_master.mode.OrderMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderActivity extends AppCompatActivity {

    @Bind(R.id.rv_list)
    RecyclerView rvList;
    @Bind(R.id.activity_order)
    LinearLayout activityOrder;

    private List<OrderListTextMode> dataList;
    private List<OrderMode> mList;
    private OrderAdapter mAdapter;
    //模拟的数据源
    private String datas = "[{\"content\":[{\"order\":\"iphone7\",\"price\":\"50.00\"},{\"order\":\"iPhone6s\",\"price\":\"50.00\"}],\"flag\":\"1\",\"orderid\":\"7582\",\"title\":\"iphone\",\"totalMoney\":\"100.00\"},{\"content\":[{\"order\":\"小米5s\",\"price\":\"30.00\"},{\"order\":\"红米4A\",\"price\":\"30.00\"}],\"flag\":\"2\",\"orderid\":\"6682\",\"title\":\"小米\",\"totalMoney\":\"60.00\"},{\"content\":[{\"order\":\"华为mate9\",\"price\":\"20.00\"},{\"order\":\"华为荣耀7\",\"price\":\"20.00\"}],\"flag\":\"3\",\"orderid\":\"5582\",\"title\":\"华为\",\"totalMoney\":\"40.00\"},{\"content\":[{\"order\":\"魅族Pro6\",\"price\":\"45.00\"}],\"flag\":\"1\",\"orderid\":\"4482\",\"title\":\"魅族\",\"totalMoney\":\"45.00\"},{\"content\":[{\"order\":\"vivoX9\",\"price\":\"35.00\"},{\"order\":\"vivoY51A\",\"price\":\"35.00\"},{\"order\":\"vivoX7全网通4G\",\"price\":\"35.00\"}],\"flag\":\"2\",\"orderid\":\"3382\",\"title\":\"VIVO\",\"totalMoney\":\"105.00\"}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        initData();
        initAdapter();
        setOnListener();
    }

    private void initData() {
        dataList = new ArrayList<>();
        //获取json数据
        dataList.addAll(GsonUtil.jsonToList(datas.toString(), OrderListTextMode.class));
        //包装的业务数据
        mList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            OrderListTextMode lMode = dataList.get(i);
            //添加标头item数据
            mList.add(new OrderMode(OrderMode.TITLE_ITEM_VIEW, lMode.getOrderid(),lMode.getTitle(),null,null,null,0));
            for (int j = 0; j < dataList.get(i).getContent().size(); j++) {
                //添加正常item数据
                mList.add(new OrderMode(OrderMode.CONTENT_ITEM_VIEW, "","",lMode.getContent().get(j).getOrder(),lMode.getContent().get(j).getPrice(),"",0));
            }
            //添加标尾item数据
            mList.add(new OrderMode(OrderMode.FOOT_ITEM_VIEW,"","","","",lMode.getTotalMoney(),lMode.getFlag()));
        }
    }

    private void initAdapter() {
        rvList.setHasFixedSize(true);
        rvList.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new OrderAdapter(mList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(mAdapter);
    }

    private void setOnListener() {
        rvList.addOnItemTouchListener(new OnItemClickListener() {
            /**
             * 此点击监听方法只适用于单布局列表item点击事件
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }

            /**
             * 此点击监听方法适用于单布局和多布局的子view点击事件，并且多布局中要整条item监听也是在这里处理
             * @param adapter
             * @param view
             * @param position
             */
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                OrderMode item = mAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.tv_itemOrder_titleStore:
                        content = "标头商店名:" + item.getStoreName();
                        Toast.makeText(OrderActivity.this, content, Toast.LENGTH_LONG).show();

                        break;
                    case R.id.tv_itemOrder_footBtn:
                        content = "标尾付款键:" + item.getFlag();
                        Toast.makeText(OrderActivity.this, content, Toast.LENGTH_LONG).show();

                        break;

                    case R.id.itemOrder_contentRoot:
                        content = "中间item:" + item.getGoodsName();
                        Toast.makeText(OrderActivity.this, content, Toast.LENGTH_LONG).show();

                        break;
                }
            }
        });
    }
}
