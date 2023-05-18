package com.example.eightapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {


    EditText editText1, editText2, editText3;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        sharedPreferences  = getSharedPreferences(
                getString(R.string.preferences),
                MODE_PRIVATE);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        int value3 = Integer.valueOf(editText3.getText().toString());

        editor.putString(getString(R.string.string_element1), value1);
        editor.putString(getString(R.string.string_element2), value2);
        editor.putInt(getString(R.string.int_element), value3);

        editor.apply();
    }


    @Override
    protected void onResume() {
        super.onResume();

        String keyEl1 = getString(R.string.string_element1);
        String keyEl2 = getString(R.string.string_element2);
        String KeyEl3 = getString(R.string.int_element);




        String stringEl1 = sharedPreferences.getString(keyEl1, "default1");
        String stringEl2 = sharedPreferences.getString(keyEl2, "default2");
        int intEl3 = sharedPreferences.getInt(KeyEl3,0);



        editText1.setText(stringEl1);
        editText2.setText(stringEl2);
        editText3.setText(String.valueOf(intEl3));
    }
}
