package com.example.myapplication;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.fragment.ViewerPresenter;

public class SecondActivity extends BaseActivity {

    private FrameLayout conteiner;
    private FragmentViewer fragmentViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        conteiner = findViewById(R.id.fragment_container);
        fragmentViewer = new FragmentViewer();
        fragmentViewer.setPresenter(new ViewerPresenter());
        getSupportFragmentManager().beginTransaction().add(conteiner.getId(), fragmentViewer).commit();
    }

}
