package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapplication.base.BaseActivity;

public class AddPhone extends BaseActivity {

    private AppCompatButton ok, cansel;
    private AppCompatEditText namePhone, ram, modelCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        initToolbar(getString(R.string.addPhone));
        ok = findViewById(R.id.bnt_ok);
        cansel = findViewById(R.id.bnt_cansel);
        namePhone = findViewById(R.id.add_name_phone);
        ram = findViewById(R.id.add_ram);
        modelCPU = findViewById(R.id.add_model_cpu);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultMain();
            }
        });
        cansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent();
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    public void setResultMain() {
        String newNamePhone = namePhone.getText().toString();
        String newRam = ram.getText().toString();
        String newModelCPU = modelCPU.getText().toString();
        if (!TextUtils.isEmpty(newModelCPU) && TextUtils.isEmpty(newNamePhone) && TextUtils.isEmpty(newRam)) {
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
}
