package com.example.kimdonggeun.rgb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class form_viewpageradapter extends FragmentPagerAdapter {
        private int tapCount;


        public form_viewpageradapter(FragmentManager fm){
            super(fm);
        }


        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0:
                    return new form_item();
                case 1:
                    return new form_item();
                case 2:
                    return new form_item();
                case 3:
                    return new main_graph();
                default:
                    return null;
            }

        }
        @Override
        public int getCount(){
            return 4;
        }



    }