package com.example.bijan.viewpagerdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bijan on 1/7/2017.
 */

public class MyDatabase {

    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;

    public  MyDatabase(Context context){
        myHelper = new MyHelper(context, "wbut.db", null, 1);
    }

    public void open(){
        sqLiteDatabase = myHelper.getWritableDatabase();
    }

    public void insertStudent(String name, String sub, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("sub", sub);
        contentValues.put("email", email);
        sqLiteDatabase.insert("student", null, contentValues);
    }

    public Cursor quaryStudent(){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("student", null, null, null, null, null, null);

        return cursor;
    }

    public  void close(){
        sqLiteDatabase.close();
    }

    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table student(_id integer primary key, name text, sub text, email text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}


