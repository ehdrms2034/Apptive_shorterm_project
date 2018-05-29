package com.example.kimdonggeun.rgb;

import android.provider.BaseColumns;

/**
 * Created by yuri on 2018. 5. 25..
 */

public class Graph_CalenderItem {

    int year, month, date, day;//날짜_숫자
    String colorCode;//요일_문자, 컬러코드_문자

    public Graph_CalenderItem(int year, int month, int date, int day, String colorCode) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.day = day;
        this.colorCode = colorCode;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public String getColorCode() {
        return colorCode;
    }

    public boolean isThisMonth(int m){ return (m==month) ? true:false; }


    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public static final class CreateCalenderList implements BaseColumns {
        public static final String YEAR = "year";
        public static final String MONTH = "month";
        public static final String DATE = "date";
        public static final String DAY = "day";//day of the week
        public static final String COLORCODE = "colorcode";
        public static final String _TABLENAME0 = "usertable";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +YEAR+" integer not null , "
                +MONTH+" integer not null , "
                +DATE+" integer not null , "
                +DAY+" integer not null , "
                +COLORCODE+" text not null );";
    }
}
