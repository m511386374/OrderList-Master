package com.xuan.huda.orderlist_master;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xuan.huda.orderlist_master.activity.OrderActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 订单列表
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Bind(R.id.tv_btn1)
    TextView tvBtn1;
    @Bind(R.id.tv_btn2)
    TextView tvBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initAdapter();
        setOnListener();
    }



    private void initData() {

    }

    private void initAdapter() {

    }

    private void setOnListener() {

    }

    @OnClick({R.id.tv_btn1,R.id.tv_btn2})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_btn1:
                startActivity(new Intent(MainActivity.this,OrderActivityA.class));
                break;

            case R.id.tv_btn2:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
    }
}
