package com.example.kimdonggeun.rgb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnGraph, btnSetting;
    ViewPager container;
    View setting_DialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGraph = findViewById(R.id.btn_graph);
        btnGraph.setOnClickListener(this);
        btnSetting = findViewById(R.id.btn_setting);
        btnSetting.setOnClickListener(this);

        container = findViewById(R.id.content_frame);
        Main_PagerAdapter adapter = new Main_PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Main0_Start());
        adapter.addFragment(new Main1_Graph());
        container.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_graph:
                Intent intent = new Intent(this, GraphActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_setting:
                Dialog();
                break;
            default:
                break;
        }
    }
    public void Dialog() {
        setting_DialogView = (View) View.inflate(MainActivity.this, R.layout.setting_dialog, null);
        android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(MainActivity.this);

        dlg.setTitle("Setting");
        dlg.setIcon(R.drawable.setting_button);
        dlg.setView(setting_DialogView);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dlg.setNegativeButton("취소", null);
        dlg.show();
    }

}