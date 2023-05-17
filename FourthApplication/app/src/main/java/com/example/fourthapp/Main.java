package com.example.fourthapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    EditText numberOne, numberTwo;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        numberOne = (EditText) findViewById(R.id.num1);
        numberTwo = (EditText) findViewById(R.id.num2);

        result = (TextView) findViewById(R.id.result);
    }

    public void toPlus(View view){
        if(numberOne.getText().toString().equals("")){
            Toast.makeText(this, "Как раз ошибка", Toast.LENGTH_SHORT).show();
        }else{
            int num1 = Integer.valueOf(numberOne.getText().toString());
            int num2 = Integer.valueOf(numberTwo.getText().toString());
            int res = num1+num2;
            result.setText(String.valueOf(res));
        }

    }
    public void toMinus(View view){
        int num1 = Integer.valueOf(numberOne.getText().toString());
        int num2 = Integer.valueOf(numberTwo.getText().toString());
        int res = num1 - num2;
        result.setText(String.valueOf(res));
    }
    public void toMultiply(View view){
        int num1 = Integer.valueOf(numberOne.getText().toString());
        int num2 = Integer.valueOf(numberTwo.getText().toString());
        int res = num1 * num2;

        result.setText(String.valueOf(res));
    }
    public void toDivided(View view){
        try{
            int num1 = Integer.valueOf(numberOne.getText().toString());
            int num2 = Integer.valueOf(numberTwo.getText().toString());
            if(num2 == 0){
                throw new Exception("Деление на 0 не возможно");
            }

            double res = num1 / num2;
            result.setText(String.valueOf(res));
        }
        catch (Exception ex){
          AlertDialog.Builder builder = new AlertDialog.Builder(this);
          builder.setMessage("Делить на 0 нельзя")
                  .setTitle("Erorr")
                  .setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          result.setText("Error");
                      }
                  });
          AlertDialog dialog = builder.create();
          dialog.show();

            //Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            //result.setText("NaN");
        }

    }
}
