package com.example.jh.sqlbritedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.example.jh.sqlbritedemo.bean.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.sqldelight.SqlDelightStatement;

import java.util.ArrayList;
import java.util.List;

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
//        String json = "{\"name\":\"天平\",\"addr\":\"广东\",\"age\":21,\"gender\":\"男\",\"hobby\":\"打代码\",\"sign\":\"签名\",\"date\":\"2017-3-13 14:36:19\"}";
//
//        //初始化Gson
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapterFactory(UserAdapterFactory.create()) //注册自定义的TypeAdapterFactory
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")   //设置json里面的Date格式
//                .create();
//
//        //开始解析
//        User user = gson.fromJson(json,User.class);
//
//        //输出结果
//        Log.e("@@", "onCreate: "+user.toString());


        //创建获取名字为tp的数据库
        SQLiteDatabase sqLiteDatabase = new StuDBHelp(this,"tp",null,1).getWritableDatabase();
        //插入数据
        sqLiteDatabase.insert("user",null,createContentValues(0,"天平",21));
        sqLiteDatabase.insert("user",null,createContentValues(1,"逼辉",23));

        Log.e("@@", "数据数量:: "+getAllUsers(sqLiteDatabase).size());

    }


    public List<User> getAllUsers(SQLiteDatabase db) {
        List<User> result = new ArrayList<>();
//创建 SqlDelightStatement对象，里面有查询字符串和参数
        SqlDelightStatement query = User.FACTORY.select_by_name("天平");

        //try_with_resources写法，括号里面的资源需要继承AutoCloseable，作用是可以自动关闭对象
        try (Cursor cursor = db.rawQuery(User.FACTORY.select_by_name("天平").statement, query.args)) {

            while (cursor.moveToNext()) {
                result.add(User.SELECT_ALL_MAPPER.map(cursor));
            }

        }

        return result;
    }


    public ContentValues createContentValues(int id,String name,int age){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",id);
        contentValues.put("name",name);
        contentValues.put("age",age);
        return  contentValues;
    }


    class StuDBHelp extends SQLiteOpenHelper{

        public StuDBHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //第一次创建数据库的调用的方法
        @Override
        public void onCreate(SQLiteDatabase db) {
            //db.execSQL(User.CREATE_TABLE);
            //创建表
            db.execSQL(User.CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
