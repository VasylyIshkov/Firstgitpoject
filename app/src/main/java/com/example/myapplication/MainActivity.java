package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.base.BaseActivity;

public class MainActivity extends BaseActivity {
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
        initToolbar(getString(R.string.main_activity_title));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      //  Toast.makeText(this,"First",Toast.LENGTH_LONG).show();
        if(item.getItemId() == R.id.menu_main_setting) {
            Toast.makeText(this,"First1",Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(this,"Second1",Toast.LENGTH_LONG).show();
        return true;
    }
    private void SendClick(){
        if(!editText.getText().toString().equals("")){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("message",editText.getText().toString());
            startActivityForResult(intent, 1);
        }
        else{
            Toast.makeText(this,"Введите текст!",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String res = data.getStringExtra("answer");
        if (res.equals("Ok")) Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
        else editText.setText(null);
    }

}
