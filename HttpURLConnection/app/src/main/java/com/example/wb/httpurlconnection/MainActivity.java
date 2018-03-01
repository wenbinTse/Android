package com.example.wb.httpurlconnection;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    final int RESULT = 1,EXCEPTION = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        new MyThread().start();
    }

    private class MyThread extends Thread{
        @Override
        public void run(){
            Message message = new Message();
            try{
                URL url = new URL("https://www.baidu.com");
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setConnectTimeout(10*1000);
                con.setDoInput(true); //允许输入流，即允许下载
                con.setDoOutput(true); //允许输出流，即允许上传
                con.setUseCaches(false); //不使用缓冲
                con.setRequestMethod("GET"); //使用get请求
                if(con.getResponseCode()!=200)
                    throw new Exception(con.getResponseCode()+"");
                InputStream in = con.getInputStream();
                BufferedReader bin= new BufferedReader(new InputStreamReader(in));
                StringBuffer result = new StringBuffer();
                String line;
                while((line = bin.readLine())!=null){
                    result.append(line);
                }
                message.what = RESULT;
                message.obj = result.toString();
            }catch (Exception e){
                message.what = EXCEPTION;
                message.obj = e.toString();
            }finally {
               mHandler.sendMessage(message);
            }
        }
    }

    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case RESULT:
                    textView.setText((String)msg.obj);
                    break;
                case EXCEPTION:
                    textView.setText("错误代码："+msg.obj.toString());
                    break;
            }

        }
    };
}
