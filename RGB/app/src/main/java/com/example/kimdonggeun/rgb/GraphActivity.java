package com.example.kimdonggeun.rgb;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by yuri on 2018. 5. 22..
 */

public class GraphActivity extends AppCompatActivity implements View.OnClickListener{

    Graph_CalenderAdpater adapter_week, adapter_month;
    ImageButton btnHome;

    private DBOpenHelper mDbOpenHelper;
    static ArrayList<Graph_CalenderItem> arrayData, weekData, monthData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);

        btnHome = findViewById(R.id.btn_graph_home);
        btnHome.setOnClickListener(this);

        GridView gridView_week = findViewById(R.id.graph_calenderView_week);

        ArrayList<Graph_CalenderItem> itemList_week = new ArrayList<>();


        ///////////////

        mDbOpenHelper = new DBOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();
        mDbOpenHelper.deleteAllColumns();

        int dayOfweek=6;
        for(int i=0; i<30; i++) {
            mDbOpenHelper.insertColumn(2018, 4, i+1, dayOfweek, "#ffff74");
            if(dayOfweek==6) dayOfweek=0;
            else dayOfweek++;
        }

        for(int i=0; i<31; i++) {
            mDbOpenHelper.insertColumn(2018, 5, i+1, dayOfweek, "#820080");
            if(dayOfweek==6) dayOfweek=0;
            else dayOfweek++;
        }
        for(int i=0; i<30; i++) {
            mDbOpenHelper.insertColumn(2018, 6, i+1, dayOfweek, "#ffff74");
            if(dayOfweek==6) dayOfweek=0;
            else dayOfweek++;
        }

//        arrayData =  new ArrayList<>();
//        showDatabase();
        weekData =  new ArrayList<>();

        //오늘 날짜
        Calendar cal = Calendar.getInstance();

        //현재 년도, 월, 일
        int year = cal.get ( cal.YEAR );
        int month = cal.get ( cal.MONTH ) + 1 ;
        int date = cal.get ( cal.DATE ) ;

        Log.e("findDataPosition1", year + "." +month + "."+date);
        showDatabase_Week(year, month, date);

        adapter_week = new Graph_CalenderAdpater(this, R.layout.graph_calender_item,weekData);
        gridView_week.setAdapter(adapter_week);


        GridView gridView_month = findViewById(R.id.graph_calenderView_month);
        //그리드뷰 스크롤 방지
        gridView_month.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    return true;
                }
                return false;
            }
        });

        monthData = new ArrayList<>();
        showDatabase_Month(year, month);

        adapter_month = new Graph_CalenderAdpater(this, R.layout.graph_calender_item,monthData);
        gridView_month.setAdapter(adapter_month);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_graph_home:
                finish();
                break;
            default:
                break;
        }
    }

    public void showDatabase(){
        Cursor iCursor = mDbOpenHelper.selectColumns();
        Log.e("showDatabase", "DB Size: " + iCursor.getCount());

        while(iCursor.moveToNext()){
            Graph_CalenderItem data = new Graph_CalenderItem(
                    iCursor.getInt(iCursor.getColumnIndex("year")),
                    iCursor.getInt(iCursor.getColumnIndex("month")),
                    iCursor.getInt(iCursor.getColumnIndex("date")),//날짜
                    iCursor.getInt(iCursor.getColumnIndex("day")),//요일
                    iCursor.getString(iCursor.getColumnIndex("colorCode"))
            );
            arrayData.add(data);
        }
        iCursor.close();
    }

    public void showDatabase_Week(int year, int month, int date){
        Cursor iCursor = mDbOpenHelper.selectColumns();
        int[] cur_Data = findDataPosition(year, month, date);//해당 날짜의 커서 위치값[0], 요일[1] 정보 구하기

        for(int i=0; i < 7; i++) {
            iCursor.moveToPosition((cur_Data[0]-cur_Data[1]) +i );//월요일부터 시작
            Graph_CalenderItem data = new Graph_CalenderItem(
                    iCursor.getInt(iCursor.getColumnIndex("year")),
                    iCursor.getInt(iCursor.getColumnIndex("month")),
                    iCursor.getInt(iCursor.getColumnIndex("date")),//날짜
                    iCursor.getInt(iCursor.getColumnIndex("day")),//요일
                    iCursor.getString(iCursor.getColumnIndex("colorCode"))
            );
            weekData.add(data);
        }
        iCursor.close();
    }

    public void showDatabase_Month(int year, int month){
        Cursor iCursor = mDbOpenHelper.selectColumns();
        int[] cur_Data = findDataPosition(year, month, 1);//해당 날짜의 커서 위치값[0], 요일[1] 정보 구하기

        for(int i=0; i < 45; i++) {
            iCursor.moveToPosition((cur_Data[0]-cur_Data[1])+i);//월요일부터 시작//~ 5주

            Graph_CalenderItem data = new Graph_CalenderItem(
                    iCursor.getInt(iCursor.getColumnIndex("year")),
                    iCursor.getInt(iCursor.getColumnIndex("month")),
                    iCursor.getInt(iCursor.getColumnIndex("date")),//날짜
                    iCursor.getInt(iCursor.getColumnIndex("day")),//요일
                    iCursor.getString(iCursor.getColumnIndex("colorCode"))
            );
            weekData.add(data);
        }
        iCursor.close();
    }


    private int[] findDataPosition(int year, int month, int date){//
        Cursor cursor = mDbOpenHelper.selectColumns();
        int[] cur_Data={ 0, 0};//커서 위치 [0], 요일 [1]

        Log.e("findDataPosition", year + "." +month + "."+date);
        while(cursor.moveToNext()){
            if(year == cursor.getInt(cursor.getColumnIndex("year"))
                    && month == cursor.getInt(cursor.getColumnIndex("month"))
                    && date == cursor.getInt(cursor.getColumnIndex("date"))){
                cur_Data[0] = cursor.getPosition();
                cur_Data[1] = cursor.getInt(cursor.getColumnIndex("day"));
                Log.e("findDataPosition", "cursor position : " + cur_Data[0] + ", day of the week : " + cur_Data[1]);
                break;
            }
        }

        return cur_Data;
    }
}
