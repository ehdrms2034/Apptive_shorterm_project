package com.example.kimdonggeun.rgb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuri on 2018. 5. 27..
 */

public class DBOpenHelper {

    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DataBaseHelper mDBHelper;
    private Context mCtx;

    public class DataBaseHelper extends SQLiteOpenHelper {

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Graph_CalenderItem.CreateCalenderList._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Graph_CalenderItem.CreateCalenderList._TABLENAME0);
            onCreate(db);
        }
    }

    public DBOpenHelper(Context context){
        this.mCtx = context;
    }

    public DBOpenHelper open() throws SQLException {
        mDBHelper = new DataBaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDB.close();
    }

    // Delete All
    public void deleteAllColumns() {
        mDB.delete(Graph_CalenderItem.CreateCalenderList._TABLENAME0, null, null);
    }

    // Insert DB
    public long insertColumn(int year, int month, int date, int day, String colorCode){
        ContentValues values = new ContentValues();
        values.put(Graph_CalenderItem.CreateCalenderList.YEAR, year);
        values.put(Graph_CalenderItem.CreateCalenderList.MONTH, month);
        values.put(Graph_CalenderItem.CreateCalenderList.DATE, date);
        values.put(Graph_CalenderItem.CreateCalenderList.DAY, day);
        values.put(Graph_CalenderItem.CreateCalenderList.COLORCODE, colorCode);
        return mDB.insert(Graph_CalenderItem.CreateCalenderList._TABLENAME0, null, values);
    }

    // Select DB
    public Cursor selectColumns(){
        return mDB.query(Graph_CalenderItem.CreateCalenderList._TABLENAME0, null, null, null, null, null, null);
    }

    // sort by column
    public Cursor sortColumn(String sort) {
        Cursor c = mDB.rawQuery("SELECT * FROM usertable ORDER BY " + sort + ";", null);
        return c;
    }



}
