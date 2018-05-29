package com.example.kimdonggeun.rgb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PopupWindow_viewpageradapter extends FragmentPagerAdapter {
        private int tapCount;


        public PopupWindow_viewpageradapter(FragmentManager fm){
            super(fm);
        }


        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0:
                    return new PopupWindow_item();
                case 1:
                    return new PopupWindow_item();
                case 2:
                    return new PopupWindow_item();
                default:
                    return null;
            }

        }
        @Override
        public int getCount(){
            return 3;
        }



    }