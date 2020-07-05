package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }
    public void onClick(View v){
        String text = editText.getText().toString();
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
    public void onCansel(View v){
        Toast.makeText(this,"CanselClick",Toast.LENGTH_LONG).show();
        editText.setText("");
    }
}
