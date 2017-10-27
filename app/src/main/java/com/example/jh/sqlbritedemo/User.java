package com.example.jh.sqlbritedemo;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.ryanharter.auto.value.parcel.ParcelAdapter;


import java.util.Date;

/**
 * Created by jinhui on 2017/10/27.
 * Email：1004260403@qq.com
 */

@AutoValue
public abstract class User implements Parcelable {

    abstract String name();
    abstract String addr();
    abstract int age();
    abstract String gender();
    abstract String hobby();
    abstract String sign();

    //需要注解自定义的TypeAdapter
    @ParcelAdapter(DateTypeAdapter.class)
    public abstract Date date();

    //创建User，内部调用的是AutoValue_User
    static User create(String name, String addr, int age, String gender, String hobby, String sign, Date date){
        return new AutoValue_User(name,addr,age,gender,hobby,sign, date);
    }

    //添加一个TypeAdapter<User>，这个TypeAdapter是Gson包里面的。
    public static TypeAdapter<User> typeAdapter(Gson gson){
        // AutoValue_User.GsonTypeAdapter 需要先make一下module之后才会生成
        return new AutoValue_User.GsonTypeAdapter(gson)
                .setDefaultAddr("默认地址");  //还可以设置默认值

    }
}
