package com.example.kimdonggeun.rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

public class PopupWindow_item extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.popupwindow_item,container,false);

        SeekBar seekBar2=(SeekBar)root.findViewById(R.id.form_seekbar2);

        return root;


    }

}