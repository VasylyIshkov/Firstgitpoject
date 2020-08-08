package com.example.myapplication;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.HistoryFragment;
import com.example.myapplication.fragment.HistoryPresenter;

public class AddPhone extends BaseActivity {
    private HistoryFragment historyFragment;
    private FrameLayout conteiner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        conteiner = findViewById(R.id.fragment_container);
        historyFragment = new HistoryFragment();
        historyFragment.setPresenter(new HistoryPresenter(getIntent()));
        getSupportFragmentManager().beginTransaction().add(conteiner.getId(), historyFragment).commit();

    }
}
