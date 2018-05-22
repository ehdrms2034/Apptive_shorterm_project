package com.example.kimdonggeun.rgb;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnGraph;
    ViewPager container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGraph = findViewById(R.id.btn_graph);
        btnGraph.setOnClickListener(this);

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
                Toast.makeText(this, "heheh", Toast.LENGTH_LONG);
                Intent intent = new Intent(this, GraphActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
