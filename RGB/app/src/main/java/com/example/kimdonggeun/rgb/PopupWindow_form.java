package com.example.kimdonggeun.rgb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class PopupWindow_form extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= getLayoutInflater().inflate(R.layout.popupwindow_form,null);
        setContentView(view);



        ImageButton exit_btn = (ImageButton)findViewById(R.id.form_exit_btn);
        exit_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
            finish();
            }
        });

        //viewpager

        ViewPager viewpager = (ViewPager)view.findViewById(R.id.form_view_pager);
        viewpager.setAdapter(new PopupWindow_viewpageradapter(getSupportFragmentManager()));


    }




}
