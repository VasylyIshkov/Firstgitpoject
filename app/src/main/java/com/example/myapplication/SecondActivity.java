package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;

public class SecondActivity extends BaseActivity {

    Button ok, cansel;
    TextView textFromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textFromMain = findViewById(R.id.text_from_main_activity);
        ok = findViewById(R.id.ok);
        cansel = findViewById(R.id.cansel);
        String message = getIntent().getStringExtra("message");
        textFromMain.setText(message);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okClick();
            }
        });
        cansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canselClick();
            }
        });
        initToolbarWithNavigation(getString(R.string.second_activity_title));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_main_setting) {
            Toast.makeText(this, "First2", Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(this, "Second2", Toast.LENGTH_LONG).show();
        return true;
    }

    private void okClick() {
        Intent intent = new Intent();
        intent.putExtra("answer", "Ok");
        setResult(RESULT_OK, intent);
        finish();
    }

    private void canselClick() {
        Intent intent = new Intent();
        intent.putExtra("answer", "Cansel");
        setResult(RESULT_OK, intent);
        finish();
    }

}
