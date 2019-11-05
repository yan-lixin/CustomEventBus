package com.eventbus.sample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.eventbus.EventBus;
import com.eventbus.annotation.Subscribe;
import com.eventbus.annotation.mode.ThreadMode;
import com.eventbus.sample.model.EventBean;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019-04-24
 * Description:
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onPost(View view) {
        EventBus.getDefault().post(new EventBean("发布的普通事件"));
    }

    public void onCancel(View view) {
        finish();
    }

    public void onActiveSticky(View view) {
        EventBus.getDefault().register(this);
        EventBus.getDefault().removeStickyEvent(EventBean.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEvent(EventBean eventBean) {
        Log.e("TAG", "接收到粘性事件: " + eventBean.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBean eventBean = EventBus.getDefault().getStickyEvent(EventBean.class);
        Log.e("TAG", "onResume接收到粘性事件: " + eventBean.toString());
    }
}
