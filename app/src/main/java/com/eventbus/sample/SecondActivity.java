package com.eventbus.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eventbus.library.EventBus;
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
        findViewById(R.id.postBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventBean("发布的消息"));
                finish();
            }
        });
    }
}
