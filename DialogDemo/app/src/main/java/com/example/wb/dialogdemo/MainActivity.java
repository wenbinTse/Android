package com.example.wb.dialogdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button ordinaryDialogBtn,listDialogBtn,customDialogBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ordinaryDialogBtn = (Button)findViewById(R.id.button1);
        listDialogBtn = (Button)findViewById(R.id.button2);
        customDialogBtn = (Button)findViewById(R.id.button3);
        ordinaryDialogBtn.setOnClickListener(this);
        listDialogBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
        Spinner
    }

    @Override
    public void onClick(View v) {
        if(v==findViewById(R.id.button1)){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("普通对话框");
            dialog.setMessage("这是一本优秀的安卓教材书");
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        else if(v==findViewById(R.id.button2)){
            final String[] colors = new String[]{"红色","黄色","橙色","蓝色","绿色"};
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("列表对话框");
            dialog.setItems(colors, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),colors[which]+"被点击",Toast.LENGTH_LONG).show();
                }
            });
            dialog.show();
        }
        else if(v==findViewById(R.id.button3)){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            final View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog,null);
            dialog.setTitle("自定义对话框");
            dialog.setView(dialogView);
            dialog.show();
        }
    }
}
