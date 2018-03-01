package com.example.toastdemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==button1){
            Toast.makeText(getApplicationContext(), "默认样式",Toast.LENGTH_LONG).show();
        }else if(v==button2){
            Toast toast = Toast.makeText(getApplicationContext(), "自定义位置", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }else if(v==button3){
            Toast toast = Toast.makeText(getApplicationContext(),"带图片显示",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            LinearLayout view = (LinearLayout)toast.getView();
            view.addView(imageView);
            toast.show();
        }
    }
}
