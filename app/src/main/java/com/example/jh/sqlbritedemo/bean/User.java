package com.example.jh.sqlbritedemo.bean;

import android.support.annotation.NonNull;


import com.example.jh.sqlbritedemo.UserModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by jinhui on 2017/11/4.
 * Email：1004260403@qq.com
 */

@AutoValue
public abstract class User implements UserModel {

    public static final Factory<User> FACTORY = new Factory<>(new Creator<User>() {
        @Override
        public User create(long _id, @NonNull String name, long age) {
            //AutoValue_User 需要先make一下module
            return new AutoValue_User(_id,name,age);
        }
    });

    public static final RowMapper<User> SELECT_ALL_MAPPER = FACTORY.select_by_nameMapper();

}