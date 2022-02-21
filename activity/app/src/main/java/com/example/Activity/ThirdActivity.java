package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

public class ThirdActivity extends BaseActivity {
    private static final String LOG_TAG = "third_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if(data != null) {
            Log.d(LOG_TAG, data);
        }

        Log.d(LOG_TAG, "Task id is " + getTaskId());

        Button buttonThirdActivityCallBack = (Button) findViewById(R.id.buttonThirdActivityCallBack);
        buttonThirdActivityCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "hello first activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonFinishAllActivity = (Button) findViewById(R.id.buttonFinishAllActivity);
        buttonFinishAllActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "finish all activity");
                ActivityCollector.finishAll();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "hello first activity");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}