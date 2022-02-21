package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NormalActivity extends BaseActivity {
    private static final String LOG_TAG = "normal_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }
}