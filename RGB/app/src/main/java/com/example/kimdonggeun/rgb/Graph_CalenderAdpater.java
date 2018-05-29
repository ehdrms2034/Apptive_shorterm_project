package com.example.kimdonggeun.rgb;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by yuri on 2018. 5. 25..
 */

public class Graph_CalenderAdpater extends BaseAdapter {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Graph_CalenderItem> items;
    private String[] dayOftheWeek = {"월", "화", "수", "목", "금", "토", "일"};

    public Graph_CalenderAdpater(Context context, int layout, ArrayList<Graph_CalenderItem> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.items = data;

    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(layout, parent, false);
        }
        Graph_CalenderItem calenderItem = items.get(position);

        TextView date = convertView.findViewById(R.id.graph_calender_date);
        TextView day = convertView.findViewById(R.id.graph_calender_day);
        date.setText(String.valueOf(calenderItem.getDate()));
        day.setText(dayOftheWeek[calenderItem.getDay()]);

        Drawable showColor = convertView.findViewById(R.id.calender_color).getBackground();
        showColor.setColorFilter(Color.parseColor(calenderItem.getColorCode()), PorterDuff.Mode.SRC_ATOP);


        Calendar cal = Calendar.getInstance();
        int cur_Month= cal.get ( cal.DATE ) ;

        if(!calenderItem.isThisMonth(cur_Month)){
            convertView.findViewById(R.id.graph_calender_card).setBackgroundColor(Color.parseColor("#88ffffff"));
        }
        return convertView;
    }
}
