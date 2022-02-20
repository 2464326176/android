package com.example.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "first_activity";

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d(LOG_TAG, returnData);
                }
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "click add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "click remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click button of start please!!!",
                        Toast.LENGTH_SHORT).show();
                // display
                /*Intent intent = new Intent(MainActivity.this, second_activity.class);
                startActivity(intent);*/

                // implicit
                Intent intent = new Intent("com.example.Activity.ACTION_START");
                intent.addCategory("android.intent.category.MY_CATEGORY");
                startActivity(intent);
            }
        });

        Button buttonBrowser = (Button) findViewById(R.id.buttonBrowser);
        buttonBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button buttonThirdActivity = (Button) findViewById(R.id.buttonThirdActivity);
        buttonThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "third activity";
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                Log.d(LOG_TAG, data);
                intent.putExtra("extra_data", data);
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });

        Button buttonCallPhone = (Button) findViewById(R.id.buttonCallPhone);
        buttonCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

    }
}