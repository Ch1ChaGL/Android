package com.example.tenapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity {

    String[] items = {"item1", "item2", "item3", "item4", "item5"};

    TextView textView;
    View currentView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.le);
        adapter.addAll(items);

        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentView != null){
                    currentView.setBackgroundColor(ContextCompat.getColor(Main.this, R.color.white));
                }
                currentView = view;
                currentView.setBackgroundColor(ContextCompat.getColor(Main.this, R.color.purple_200));
            }
        };
        listView.setOnItemClickListener(itemClickListener);

        textView = (TextView) findViewById(R.id.tv);

    }

    public void onCheckBoxClicked(View view){
        CheckBox checkBox = (CheckBox) view;

        boolean checked = checkBox.isChecked();

       if(view.getId() == R.id.cb1){
           if(((CheckBox) view).isChecked()){
               textView.setText("Вы выбрали JS");
           }
       }else if(view.getId() == R.id.cb2){
           if(((CheckBox) view).isChecked()){
               textView.setText("Вы выбрали Java");
           }
       }


    }

}
