package com.example.nineapp;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    String[] countries = {"Бразилия", "Аргенитина", "Колумбия", "Чили", "Уругвай"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        Spinner spinner1 = (Spinner) findViewById(R.id.spiner);
        TextView textView1 = (TextView) findViewById(R.id.tv1);

        Spinner spinner2 = (Spinner) findViewById(R.id.spiner2);
        TextView textView2 = (TextView) findViewById(R.id.tv2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.addAll(countries);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s;
                if(parent == spinner1)
                {
                    s = (String) parent.getItemAtPosition(position);
                    textView1.setText(s);
                }
                if(parent == spinner2)
                {
                    s = (String) parent.getItemAtPosition(position);
                    textView2.setText(s);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(itemSelectedListener);
        spinner2.setOnItemSelectedListener(itemSelectedListener);
    }
}
