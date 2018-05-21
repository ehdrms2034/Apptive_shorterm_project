package com.example.kimdonggeun.rgb;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button)findViewById(R.id.popup_btn);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent forms = new Intent(MainActivity.this,form.class);
                startActivity(forms);

            }
        });

    }
}
