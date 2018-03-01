package com.example.wb.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner1,spinner2,spinner3;
    TextView textView1,textView2,textView3;
    ArrayAdapter<String> defaultAdapter;
    MyAdapter myAdapter;
    String[] cities1 = new String[]{"杭州","长沙","成都","武汉"};
    City[] cities2 = new City[]{new City("浙江","杭州"),new City("湖南","长沙"),
            new City("四川","成都"),new City("湖北","武汉")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        //使用默认Adapter与spinner2绑定
        defaultAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cities1);
        defaultAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2 .setAdapter(defaultAdapter);
        //使用自定义Adapter与spinner3绑定
        myAdapter = new MyAdapter(this, Arrays.asList(cities2));
        spinner3.setAdapter(myAdapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent==spinner1){
            String[] cities =getResources().getStringArray(R.array.cities);
            textView1.setText(cities[position]);
        }else if(parent==spinner2){
           textView2.setText(cities1[position]);
        }else  if(parent==spinner3){
            textView3.setText(cities2[position].getProvince()+" "+cities2[position].getCity());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
