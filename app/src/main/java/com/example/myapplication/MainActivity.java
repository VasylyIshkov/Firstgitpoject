package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText editText;
 Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.EditText);
        send = findViewById(R.id.Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendClick();
            }
        });
    }

    private void SendClick(){
        if(editText.getText().toString().length()>0){
            Toast.makeText(this,editText.getText().toString(),Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Введите текст!",Toast.LENGTH_LONG).show();
        }
    }

}
