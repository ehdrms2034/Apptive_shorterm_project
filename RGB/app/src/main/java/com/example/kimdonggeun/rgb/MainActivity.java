package com.example.kimdonggeun.rgb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnGraph, btnGuide, btnNext;
    ViewPager container;
    Boolean guideOn=true;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGraph = findViewById(R.id.btn_graph);
        btnGraph.setOnClickListener(this);

        if(guideOn){
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            guideOn = !guideOn;
        }
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
            default:
                break;
        }
    }
<<<<<<< HEAD
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

        TextView delete_database = (TextView)setting_DialogView.findViewById(R.id.setting3_DeleteDatabase);
        delete_database.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String TABLE_NAME="graph_data";
                graph_data_Sqliteopenhelper datasqlhelper=new graph_data_Sqliteopenhelper(getBaseContext(),"graphdata1.db",null,1);
                SQLiteDatabase db = datasqlhelper.getWritableDatabase();
                String DROP_SQL = "drop table if exists "+"graph_data";
                Log.d("hi","hi");
                try{
            db.execSQL(DROP_SQL);
                    Log.d("hi","hi");
                }catch(Exception e){

                           }

                String CREATE_SQL="create table if not exists "+TABLE_NAME+" ("
                        +"number integer PRIMARY KEY autoincrement, "
                        +"year integer, "
                        +"month integer, "
                        +"days integer,"
                        +"weekofdays integer,"
                        +"num_r integer,"
                        +"num_g integer,"
                        +"num_b integer,"
                        +"value text"
                        + ")";


                //데이터 생성
                try{
                    db.execSQL(CREATE_SQL);

                }catch (Exception e){
                    Log.e(TAG,"Exception in CREATE_sql",e);
                }
                Log.d(TAG,"oncreate 잘작동");

            }
        });
        dlg.show();
    }

=======
>>>>>>> guide page
}