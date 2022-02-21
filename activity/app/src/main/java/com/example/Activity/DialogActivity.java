package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DialogActivity extends BaseActivity {
    private static final String LOG_TAG = "dialog_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}