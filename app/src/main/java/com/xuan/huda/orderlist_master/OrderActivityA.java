package com.xuan.huda.orderlist_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderActivityA extends AppCompatActivity {

    @Bind(R.id.rv_many4)
    RecyclerView rvMany4;

    private List<OrderListTextMode> dataList;
    private List<OrderListMode> mList;
    private AdapterD mAdapter;
    //模拟的数据源
    private String datas = "[{\"content\":[{\"order\":\"iphone7\",\"price\":\"50.00\"},{\"order\":\"iPhone6s\",\"price\":\"50.00\"}],\"flag\":\"1\",\"orderid\":\"7582\",\"title\":\"iphone\",\"totalMoney\":\"100.00\"},{\"content\":[{\"order\":\"小米5s\",\"price\":\"30.00\"},{\"order\":\"红米4A\",\"price\":\"30.00\"}],\"flag\":\"2\",\"orderid\":\"6682\",\"title\":\"小米\",\"totalMoney\":\"60.00\"},{\"content\":[{\"order\":\"华为mate9\",\"price\":\"20.00\"},{\"order\":\"华为荣耀7\",\"price\":\"20.00\"}],\"flag\":\"3\",\"orderid\":\"5582\",\"title\":\"华为\",\"totalMoney\":\"40.00\"},{\"content\":[{\"order\":\"魅族Pro6\",\"price\":\"45.00\"}],\"flag\":\"1\",\"orderid\":\"4482\",\"title\":\"魅族\",\"totalMoney\":\"45.00\"},{\"content\":[{\"order\":\"vivoX9\",\"price\":\"35.00\"},{\"order\":\"vivoY51A\",\"price\":\"35.00\"},{\"order\":\"vivoX7全网通4G\",\"price\":\"35.00\"}],\"flag\":\"2\",\"orderid\":\"3382\",\"title\":\"VIVO\",\"totalMoney\":\"105.00\"}]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderactivity_a);
        ButterKnife.bind(this);

        initData();
        initAdapter();
        setOnListener();
    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.addAll(GsonUtil.jsonToList(datas.toString(), OrderListTextMode.class));
        mList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            mList.add(new OrderListMode(1, dataList.get(i).getOrderid(),dataList.get(i).getTitle()));
            for (int j = 0; j < dataList.get(i).getContent().size(); j++) {
                Log.i("----",dataList.get(i).getContent().get(j).getOrder());
                mList.add(new OrderListMode(2,dataList.get(i).getContent().get(j).getOrder(),dataList.get(i).getContent().get(j).getPrice(),1));
            }
            mList.add(new OrderListMode(3,dataList.get(i).getTotalMoney(),dataList.get(i).getFlag()));
        }
    }

    private void initAdapter() {
        rvMany4.setHasFixedSize(true);
        rvMany4.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new AdapterD(OrderActivityA.this,mList);
        rvMany4.setLayoutManager(new LinearLayoutManager(this));
        rvMany4.setAdapter(mAdapter);
    }

    private void setOnListener() {

    }
}
