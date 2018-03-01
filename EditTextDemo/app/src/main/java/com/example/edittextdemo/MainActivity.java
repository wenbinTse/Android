package com.example.edittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText userNameEdit,passwdEdit;
    Button loginButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdit = (EditText)findViewById(R.id.editText1);
        passwdEdit   = (EditText)findViewById(R.id.editText2);
        loginButton  = (Button)findViewById(R.id.button);
        textView     = (TextView)findViewById(R.id.textView);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userNameEdit.getText().toString().equals("android")&&passwdEdit.getText().toString().equals("123"))
                    textView.setText("登录成功");
                else
                    textView.setText("登录失败");
            }
        });
    }
}
