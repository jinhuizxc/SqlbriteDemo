package com.example.jh.sqlbritedemo;

import android.os.Parcel;

import com.ryanharter.auto.value.parcel.TypeAdapter;

import java.util.Date;

/**
 * Created by jinhui on 2017/10/27.
 * Email：1004260403@qq.com
 */

public class DateTypeAdapter implements TypeAdapter<Date> {
    public Date fromParcel(Parcel in) {
        return new Date(in.readLong());
    }

    public void toParcel(Date value, Parcel dest) {
        dest.writeLong(value.getTime());
    }
}
