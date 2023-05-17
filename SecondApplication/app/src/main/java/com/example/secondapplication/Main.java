package com.example.secondapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity
{
    TextView textView1, textView2;
    Button buttonAdd, buttonCopy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);


        textView1 = (TextView)findViewById(R.id.tv1);
        textView2 = (TextView)findViewById(R.id.tv2);

        buttonAdd = (Button) findViewById(R.id.btn1);
        buttonCopy = (Button) findViewById(R.id.btn2);
    }

    public  void onAdd(View v){
        String s = textView1.getText().toString();
        buttonAdd.setText(s);
    }
    public  void onCopy(View v){
      String s1 = "вторая надпись: " + textView2.getText().toString();
      String s2 = ", первая кнопка: " + buttonAdd.getText().toString();
      buttonCopy.setText(s1+s2);
    }
}
