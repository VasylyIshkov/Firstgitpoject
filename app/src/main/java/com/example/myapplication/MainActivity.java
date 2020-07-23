package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.OnPhoneRecyclerItemClickListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    RecyclerView recyclerView;
    boolean inLandscapeMode;


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

        if (inLandscapeMode) {
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        }


    }


    private void displaySelected(Phone phone) {
        Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
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

}
