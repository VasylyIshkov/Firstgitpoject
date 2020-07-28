package com.example.myapplication;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddPhone extends BaseActivity {

    private AppCompatButton ok, cansel;
    private AppCompatEditText namePhone, ram, modelCPU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        initToolbarWithNavigation(getString(R.string.addPhone));
        ok = findViewById(R.id.bnt_ok);
        ok.setOnClickListener(new View.OnClickListener() {
          //  HardTask tmp = new HardTask();
            @Override
            public void onClick(View v) {
               new HardTask().execute();
                    }


        });
//        ok = findViewById(R.id.bnt_ok);
//        cansel = findViewById(R.id.bnt_cansel);
//        namePhone = findViewById(R.id.add_name_phone);
//        ram = findViewById(R.id.add_ram);
//        modelCPU = findViewById(R.id.add_model_cpu);
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setResultMain();
//            }
//        });
//        cansel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Intent intent = new Intent();
//                setResult(RESULT_CANCELED);
//                finish();
//            }
//        });
    }

    public void showMessage(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
        Log.println(Log.DEBUG, "ASYNC_TASK", mes);
    }

    public void setResultMain() {
        String newNamePhone = namePhone.getText().toString();
        String newRam = ram.getText().toString();
        String newModelCPU = modelCPU.getText().toString();
        if (!newModelCPU.equals("") && !newNamePhone.equals(" ") && !newRam.equals(" ")) {
            Intent intent = new Intent();
            intent.putExtra(Constants.NAME_PHONE, newNamePhone);
            intent.putExtra(Constants.RAM, newRam);
            intent.putExtra(Constants.MODEL_CPU, newModelCPU);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Не все поля заполненны!!!", Toast.LENGTH_LONG).show();
        }
    }

    private class HardTask extends AsyncTask<Integer, Long, String> {

        Random rd = new Random();
        long sleepTime = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showMessage("ThreadStart");
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            showMessage("sleep time = " + sleepTime);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < 10; i++) {
                try {
                    sleepTime = rd.nextInt(200);
                    Thread.sleep(sleepTime);
                    publishProgress(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            showMessage("ThreadEnd");
        }
    }
}
