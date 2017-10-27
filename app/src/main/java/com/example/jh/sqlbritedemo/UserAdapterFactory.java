package com.example.jh.sqlbritedemo;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by jinhui on 2017/10/27.
 * Email：1004260403@qq.com
 */

@GsonTypeAdapterFactory
public abstract class UserAdapterFactory implements TypeAdapterFactory {

    // 静态工厂方式
    public static TypeAdapterFactory create() {
        return new AutoValueGson_UserAdapterFactory();
    }

}
