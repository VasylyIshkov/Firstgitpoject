package com.example.myapplication.base;

import android.view.View;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public void initToolbarWithNavigation(String title) {
       // toolbar = findViewById(R.id);
        toolbar.setTitle(title);
      //  toolbar.setNavigationIcon(R.drawable.ic_back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void initToolbar(String title) {
      //  toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
    }

}