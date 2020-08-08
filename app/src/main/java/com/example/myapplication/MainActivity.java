package com.example.myapplication;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.fragment.ChooserPresenter;
import com.example.myapplication.fragment.FragmentChooser;


public class MainActivity extends BaseActivity {
    private FragmentChooser fragmentChooser;
    private FrameLayout conteiner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conteiner = findViewById(R.id.fragment_container);
        fragmentChooser = new FragmentChooser();
        fragmentChooser.setPresenter(new ChooserPresenter(new ApplicationRequestManager(MainActivity.this), getDatabase()));
        getSupportFragmentManager().beginTransaction().add(conteiner.getId(), fragmentChooser).commit();///???

    }
}

