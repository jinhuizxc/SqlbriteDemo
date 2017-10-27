package com.example.jh.sqlbritedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 * SqlBriteDemo
 *
 * com.squareup.sqlbrite.BriteDatabase 的学习！项目需要
 *
 * 参考链接：
 * http://blog.csdn.net/niubitianping/article/details/62051286
 * http://blog.csdn.net/niubitianping/article/details/62216503
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.
//        User user = User.create("天平","广东",21,"男","敲代码","没有个性签名");
//        Log.e("@@", "onCreate: "+user.toString());
        // 2.
//        User user = User.create("天平","广东",21,"男","敲代码","没有个性签名",new Date());
//        startActivity(new Intent(this,SecondActivity.class).putExtra("bean",user));
        // 3.
        //json字符串
        String json = "{\"name\":\"天平\",\"addr\":\"广东\",\"age\":21,\"gender\":\"男\",\"hobby\":\"打代码\",\"sign\":\"签名\",\"date\":\"2017-3-13 14:36:19\"}";

        //初始化Gson
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(UserAdapterFactory.create()) //注册自定义的TypeAdapterFactory
                .setDateFormat("yyyy-MM-dd HH:mm:ss")   //设置json里面的Date格式
                .create();

        //开始解析
        User user = gson.fromJson(json,User.class);

        //输出结果
        Log.e("@@", "onCreate: "+user.toString());
    }
}
