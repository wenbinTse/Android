package com.example.wb.socketdemo;

import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements OnClickListener, Runnable {
    TextView textView;
    Button button;
    EditText editText;
    Socket socket;
    private static final String HOST = "172.31.242.3";
    private static final int PORT = 2017;
    private BufferedReader in = null;
    private PrintWriter out = null;
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyLog().build());
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        button.setOnClickListener(this);
        client();
    }

    private void client(){
        try {
            socket = new Socket(HOST, PORT);
            in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream())), true);
            new Thread(this).start();
        } catch (Exception ex) {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
            textView.setText(ex.getMessage());
        }
    }

    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(str);
        }
    };
    @Override
    public void run() {
        try {
            while (true) {
                if (socket.isConnected() && !socket.isInputShutdown()) {
                        String content;
                        if ((content = in.readLine()) != null) {
                            str += "服务器："+content+"\n";
                            mHandler.sendMessage(mHandler.obtainMessage());
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View v) {
        if(v==button){
            String msg = editText.getText().toString();
            editText.setText("");
            if (editText.getText().toString()!="" && socket.isConnected() && !socket.isOutputShutdown()) {
                    out.println(msg);
                    str+="客户端："+msg+"\n";
                    textView.setText(str);
            }
        }
    }
}
