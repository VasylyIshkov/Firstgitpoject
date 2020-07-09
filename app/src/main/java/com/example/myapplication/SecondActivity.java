package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button ok,cansel;
    TextView textfrommain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textfrommain = findViewById(R.id.TextFromMainActivity);
        ok = findViewById(R.id.Ok);
        cansel = findViewById(R.id.Cansel);
    }
    private void OkClick() {

        Toast.makeText(this, "OkClick", Toast.LENGTH_LONG).show();
    }
    private void CanselClick() {

        Toast.makeText(this, "OkClick", Toast.LENGTH_LONG).show();
    }

}
