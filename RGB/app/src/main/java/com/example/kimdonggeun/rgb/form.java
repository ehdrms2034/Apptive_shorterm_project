package com.example.kimdonggeun.rgb;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static android.content.ContentValues.TAG;


public class form extends AppCompatActivity {

    public form() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= getLayoutInflater().inflate(R.layout.fragment_form,null);
        setContentView(view);



        ImageButton exit_btn = (ImageButton)findViewById(R.id.form_exit_btn);
        exit_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
            finish();
            }
        });

        //viewpager

        ViewPager viewpager = (ViewPager)view.findViewById(R.id.form_view_pager);
        viewpager.setAdapter(new form_viewpageradapter(getSupportFragmentManager()));


    }




}
