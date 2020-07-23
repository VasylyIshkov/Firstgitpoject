package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.PhoneRecyclerAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.OnPhoneRecyclerItemClickListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    private OnPhoneRecyclerItemClickListener onPhoneRecyclerItemClickListener;
    private PhoneRecyclerAdapter taskRecyclerAdapter;
    RecyclerView recyclerView;
    ArrayList<Phone> phoneArrayList;
    boolean inLandscapeMode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(getString(R.string.main_activity_title));
        inLandscapeMode = findViewById(R.id.fragment_viewer) != null;
        fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_chooser);
        onPhoneRecyclerItemClickListener = new OnPhoneRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                displaySelected(fragmentChooser.getPhone(position));
            }
        };
        fragmentChooser.setOnTaskRecyclerItemClickListener(onPhoneRecyclerItemClickListener);
        if (inLandscapeMode) {
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        }


    }




    private void displaySelected(Phone phone) {
        Toast.makeText(this,"Main",Toast.LENGTH_SHORT).show();
        if (inLandscapeMode) {
            fragmentViewer.displayResorce(phone);
        } else {
//            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//            intent.putExtra(Constants.KEY_RES_ID, phone);
//            intent.putExtra(Constants.PHONE_INFO_STR, resPhoneInfo);
//            startActivity(intent);
        }
    }

}
