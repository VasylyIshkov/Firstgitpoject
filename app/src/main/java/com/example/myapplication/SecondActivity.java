package com.example.myapplication;

import android.os.Bundle;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.FragmentViewer;

public class SecondActivity extends BaseActivity {

    private FragmentViewer fragmentViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initToolbarWithNavigation(getString(R.string.second_activity_title));
        fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        int resImageId = getIntent().getIntExtra(Constants.KEY_RES_ID, -1);
        String resPhoneInfo = getIntent().getStringExtra(Constants.PHONE_INFO_STR);
        //fragmentViewer.displayResorce(resImageId, resPhoneInfo);
    }

}
