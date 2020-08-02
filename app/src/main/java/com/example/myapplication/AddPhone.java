package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.HistoryRecyclerAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;

import java.util.ArrayList;

public class AddPhone extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> historyList;
    private OnCountryRecyclerItemClickListener listener = new OnCountryRecyclerItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent();
            intent.putExtra(Constants.CHOOSE_REQUEST, historyList.get(position));
            setResult(RESULT_OK, intent);
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        String tittle = getString(R.string.history);
        initToolbarWithNavigation(tittle);
        recyclerView = findViewById(R.id.history_list);
        historyList = getIntent().getStringArrayListExtra(Constants.CHOOSE_REQUEST);
        HistoryRecyclerAdapter adapter = new HistoryRecyclerAdapter(historyList, this, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setListener(listener);

    }
//    private AppCompatButton ok, cansel;
//    private AppCompatEditText namePhone, ram, modelCPU;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_test);
//        initToolbar(getString(R.string.addPhone));
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
//    }
//
//    public void setResultMain() {
//        String newNamePhone = namePhone.getText().toString();
//        String newRam = ram.getText().toString();
//        String newModelCPU = modelCPU.getText().toString();
//        if (!newModelCPU.equals("") && !newNamePhone.equals(" ") && !newRam.equals(" ")) {
//            Intent intent = new Intent();
//            intent.putExtra(Constants.NAME_PHONE, newNamePhone);
//            intent.putExtra(Constants.RAM, newRam);
//            intent.putExtra(Constants.MODEL_CPU, newModelCPU);
//            setResult(RESULT_OK, intent);
//            finish();
//        } else {
//            Toast.makeText(this, "Не все поля заполненны!!!", Toast.LENGTH_LONG).show();
//        }
//    }
}
