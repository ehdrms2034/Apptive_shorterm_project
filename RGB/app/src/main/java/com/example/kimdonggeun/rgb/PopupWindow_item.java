package com.example.kimdonggeun.rgb;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

@SuppressLint("ValidFragment")
public class PopupWindow_item extends Fragment {

    Button truebutton;
    Button falsebutton;

    int num_r;
    int num_g;
    int num_b;
    String question;

    @SuppressLint("ValidFragment")
    public PopupWindow_item(String string,int num_r, int num_g, int num_b) {
        question=string;
        this.num_r = num_r;
        this.num_g = num_g;
        this.num_b = num_b;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.popupwindow_item,container,false);

        TextView text= (TextView)root.findViewById(R.id.form_item_text);
        text.setText(question);
        truebutton =(Button)root.findViewById(R.id.form_item_truebutton);
        falsebutton=(Button)root.findViewById(R.id.form_item_falsebutton);


        truebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Log.v("값",num_r+" "+num_g+" "+num_b);
                ((PopupWindow_form)getActivity()).addR_seekbar(num_r);

                ((PopupWindow_form)getActivity()).addB_seekbar(num_g);

                ((PopupWindow_form)getActivity()).addG_seekbar(num_b);

                ((PopupWindow_form)getActivity()).next_viewpage();
            }
        });

        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PopupWindow_form)getActivity()).previous_viewpage();


            }
        });


        return root;

    }

}