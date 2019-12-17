package com.example.wetherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {
    private static final String dbname="Save_Weather.db";

    public DbManager(Context context) {
        super(context, dbname, null, 4);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tb1_weather (id integer primary key autoincrement, tempe text, min_tempe text, max_tempe text, decs text, date text, city text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb1_weather");
        onCreate(db);

    }

    public  String addRecord(String p1, String p2, String p3, String p4, String p5, String p6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("tempe",p1);
        cv.put("min_tempe",p2);
        cv.put("max_tempe",p3);
        cv.put("decs",p4);
        cv.put("date",p5);
        cv.put("city",p6);
        long res=db.insert("tb1_weather",null,cv);

        if (res ==1)
            return  "Αποτυχία Αποθήκευσης";
        else
            return "Επιτυχής Αποθήκευση ";

    }



    public Cursor ViewData(){
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.rawQuery("select * from tb1_weather",null);
        return  cursor;

    }
}
