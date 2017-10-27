package com.example.jh.sqlbritedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Date;

/**
 * Created by jinhui on 2017/10/27.
 * Email：1004260403@qq.com
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        User user = getIntent().getParcelableExtra("bean");
        Log.e("@@two", "onCreate: "+user.toString());

    }
}