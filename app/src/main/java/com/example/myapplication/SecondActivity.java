package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    Button ok,cansel;
    TextView textfrommain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textfrommain = findViewById(R.id.TextFromMainActivity);
        ok = findViewById(R.id.Ok);
        cansel = findViewById(R.id.Cansel);
        String message = getIntent().getStringExtra("message");
        textfrommain.setText(message);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkClick();
            }
        });
        cansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CanselClick();
            }
        });
        initToolbarWithNavigation(getString(R.string.second_activity_title));

    }
    private void OkClick() {
        Intent intent = new Intent();
        intent.putExtra("answer","Ok" );
        setResult(RESULT_OK, intent);
        finish();
    }
    private void CanselClick() {
        Intent intent = new Intent();
        intent.putExtra("answer","Cansel" );
        setResult(RESULT_OK, intent);
        finish();
    }

}
