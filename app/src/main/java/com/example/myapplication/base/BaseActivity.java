package com.example.myapplication.base;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.app.FirstProjectApp;
import com.example.myapplication.database.AppDatabase;

public class BaseActivity extends AppCompatActivity {
    public AppDatabase getDatabase() {
        return ((FirstProjectApp) getApplication()).getAppDatabase();
    }
}