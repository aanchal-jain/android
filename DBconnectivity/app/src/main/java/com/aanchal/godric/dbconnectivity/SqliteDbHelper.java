package com.aanchal.godric.dbconnectivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="student.db";
    public static final String TABLE="stud";

    public SqliteDbHelper(Context context) {
        super(context, DB_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE+"(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,password TEXT,phone TEXT,state text,city TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE);
    }

    public boolean registerUser(String name,String password,String phone,String state,String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("username",name);
        c.put("password",password);
        c.put("phone",phone);
        c.put("state",state);
        c.put("city",city);
        Long res = db.insert(TABLE,null,c);
        if(res == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE,null);
        return cursor;
    }
    public int deleteUser(String uname){
        SQLiteDatabase db = this.getWritableDatabase();
        String whereArgs[] = {uname};
        int res = db.delete(TABLE,"username=?",whereArgs);
        return res;
    }
}
