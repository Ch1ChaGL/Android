package com.example.fiveapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.lang.reflect.Array;

public class Main extends AppCompatActivity
    implements AdapterView.OnItemClickListener
{
    int currentPos;
    private View curView = null;
    ArrayAdapter<String> arrayAdapter;
    EditText editText;
    ListView listView;
    Button del;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.le);

        arrayAdapter.add("First");

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);

        del = (Button) findViewById(R.id.del);
        del.setEnabled(false);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


    }

    public void toAdd (View view){
        String text = editText.getText().toString();
        arrayAdapter.add(text);
    }
    public void toClear(View view){
        arrayAdapter.clear();
    }

    public void toEdit(View view){
        String s = arrayAdapter.getItem(currentPos);
        arrayAdapter.remove(s);
        arrayAdapter.insert(editText.getText().toString(), currentPos);

    }
    public void toDel(View view){
        arrayAdapter.remove(
                arrayAdapter.getItem(currentPos));
        del.setEnabled(false);
        curView = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        if(curView != null){
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }
        String s = arrayAdapter.getItem(position);
        currentPos = position;
        editText.setText(s);
        del.setEnabled(true);
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        curView = view;
    }
}
