package com.example.buttondemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        imageButton.setOnClickListener(this);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        textView.setText("ImageButton被点击");
        if(v==imageButton)
            textView.setText("ImageButton被点击");
        else if(v==button)
            textView.setText("Button被点击");
    }
}
