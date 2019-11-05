package com.eventbus.sample;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.eventbus.EventBus;
import com.eventbus.annotation.Subscribe;
import com.eventbus.annotation.mode.ThreadMode;
import com.eventbus.sample.model.EventBean;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().addIndex(new EventBusIndex());
        EventBus.getDefault().register(this);

        mTextView = findViewById(R.id.subscribeText);
        findViewById(R.id.navigateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBean eventBean) {
        Log.e("TAG", "接收到事件");
        mTextView.setText(eventBean.getDes());
    }

    public void onSticky(View view) {
        EventBus.getDefault().postSticky(new EventBean("发布的粘性事件"));
    }


}
