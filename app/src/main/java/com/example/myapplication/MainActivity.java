package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.OnFloatingActionButtonClickListener;
import com.example.myapplication.listeners.OnPhoneRecyclerItemClickListener;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    private RecyclerView recyclerView;
    private boolean inLandscapeMode;
    private OnFloatingActionButtonClickListener onFloatingActionButtonClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(getString(R.string.main_activity_title));
        inLandscapeMode = findViewById(R.id.fragment_viewer) != null;
        fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_chooser);
        recyclerView = findViewById(R.id.recycler_view);
        OnPhoneRecyclerItemClickListener onPhoneRecyclerItemClickListener = new OnPhoneRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                displaySelected(fragmentChooser.getPhone(position));
            }
        };
        fragmentChooser.setOnPhoneRecyclerItemClickListener(onPhoneRecyclerItemClickListener);
        onFloatingActionButtonClickListener = new OnFloatingActionButtonClickListener() {
            @Override
            public void onClick() {
                addNewPhone();
            }
        };
        fragmentChooser.setOnFloatingActionButtonClickListener(onFloatingActionButtonClickListener);
        if (inLandscapeMode) {
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        }


    }


    private void displaySelected(Phone phone) {
        if (inLandscapeMode) {
            fragmentViewer.displayResorce(phone);
        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(Constants.KEY_RES_ID, phone.getIdRes());
            intent.putExtra(Constants.NAME_PHONE, phone.getNamePhone());
            intent.putExtra(Constants.RAM, phone.getRam());
            intent.putExtra(Constants.MODEL_CPU, phone.getModelCPU());
            startActivity(intent);
        }
    }

    private void addNewPhone() {
        Intent intent = new Intent(this, AddPhone.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            Phone phone;
            String modelCPU = data.getStringExtra(Constants.MODEL_CPU);
            String namePhone = data.getStringExtra(Constants.NAME_PHONE);
            String ram = data.getStringExtra(Constants.RAM);
            int resId = R.drawable.nokia_3310;
            phone = new Phone(namePhone, modelCPU, ram, resId);
            fragmentChooser.addPhoneToArrayList(phone);
        }
    }

}
