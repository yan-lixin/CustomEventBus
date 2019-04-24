package com.eventbus.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.eventbus.library.EventBus;
import com.eventbus.library.annotation.Subscribe;
import com.eventbus.library.mode.ThreadMode;
import com.eventbus.sample.model.EventBean;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        mTextView = findViewById(R.id.subscribeText);
        findViewById(R.id.navigateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Subscribe(threadModel = ThreadMode.MAIN)
    public void onEvent(EventBean eventBean) {
        mTextView.setText(eventBean.getDes());
    }
}
