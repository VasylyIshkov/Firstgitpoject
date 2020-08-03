package com.example.myapplication.base;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.R;
import com.example.myapplication.app.FirstProjectApp;
import com.example.myapplication.database.AppDatabase;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public AppCompatButton initHistoryButton() {
        AppCompatButton historyButton = findViewById(R.id.history);
        historyButton.setVisibility(View.VISIBLE);
        return historyButton;
    }

    public void initToolbarWithNavigation(String title) {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return false;
            }
        });
    }

    public void initToolbar(String title) {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return false;
            }
        });
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public AppDatabase getDatabase() {
        return ((FirstProjectApp) getApplication()).getAppDatabase();
    }
}