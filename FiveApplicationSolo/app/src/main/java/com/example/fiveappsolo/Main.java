package com.example.fiveappsolo;

import android.os.Bundle;
import android.os.strictmode.Violation;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity
implements AdapterView.OnItemClickListener
{
    int currentPosition;
    EditText editText;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    View currentView;
    Button del, edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.le);
        arrayAdapter.add("Test1");
        arrayAdapter.add("Test2");
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        del = (Button)findViewById(R.id.del);
        edit = (Button)findViewById(R.id.edit);
        del.setEnabled(false);
        edit.setEnabled(false);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        if(currentView != null){
            currentView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        }

        currentPosition = position;
        String s = arrayAdapter.getItem(position);
        editText.setText(s);
        del.setEnabled(true);
        edit.setEnabled(true);

        currentView = view;
        currentView.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
    }

    public void toAdd(View view){
        String s = editText.getText().toString();
        arrayAdapter.add(s);
    }

    public void toClear(View view){
        arrayAdapter.clear();
    }

    public void toDel(View view){
        arrayAdapter.remove(
                arrayAdapter.getItem(currentPosition)
        );
        del.setEnabled(false);
    }
    public void toEdit(View view){
        arrayAdapter.remove(
                arrayAdapter.getItem(currentPosition)
        );
        arrayAdapter.insert(
                editText.getText().toString(),
                currentPosition);
        edit.setEnabled(false);
    }
}
