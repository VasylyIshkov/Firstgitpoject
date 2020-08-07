package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.api.ApiCallback;
import com.example.myapplication.api.RestClient;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.classes.CountryErrorItem;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.fragment.ChooserPresenter;
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;
import com.example.myapplication.utils.KeyboardUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    private boolean inLandscapeMode;
    private FrameLayout conteiner,conteinerViewer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inLandscapeMode = findViewById(R.id.fragment_viewer) != null;
        conteiner = findViewById(R.id.container_fragment);
        fragmentChooser = new FragmentChooser();
        fragmentChooser.setPresenter(new ChooserPresenter(new ApplicationRequestManager(MainActivity.this), getDatabase()));
        getSupportFragmentManager().beginTransaction().add(conteiner.getId(), fragmentChooser).commit();///???
        // fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_chooser);
        // fragmentChooser.setOnCountryRecyclerItemClickListener(onCountryRecyclerItemClickListener);
        if (inLandscapeMode) {
            conteinerViewer = findViewById(R.id.fragment_viewer);
            fragmentViewer = new FragmentViewer();
            getSupportFragmentManager().beginTransaction().add(conteinerViewer.getId(), fragmentViewer).commit();///???
        }
//        menu = getToolbar().getMenu();
//        menu.clear();
//        menu.add(R.string.history);

    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        showHistory();
//        return true;
//    }

//    private void displaySelected(CountryItem countryItem) {
//        if (inLandscapeMode) {
//            fragmentViewer.displayResorce(countryItem);
//        } else {
//            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//            intent.putExtra(Constants.COUNTRY_INFO, countryItem.getInfo());
//            intent.putExtra(Constants.FLAG_URI, countryItem.getFlag());
//            startActivity(intent);
//        }
//    }

//    private void search() {
//        if (TextUtils.isEmpty(nameCountry.getText().toString())) {
//            nameCountry.requestFocus();
//        } else {
//            KeyboardUtils.hide(nameCountry);
//            loadRepos(nameCountry.getText().toString());
//        }
//    }

    private void makeErrorToast(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

//    private void loadRepos(String countryName) {
//        ApplicationRequestManager.setRequest(nameCountry.getText().toString(), this);
//        fragmentChooser.showProgressBlock();
//        RestClient.getsIstance().getApiService().getUserRepos(countryName).enqueue(new ApiCallback<List<CountryItem>>() {
//
//
//            @Override
//            public void success(Response<List<CountryItem>> response) {
//                if (!response.isSuccessful()) {
//                    if (response.body() != null) {
//                        updateData(response.body());
//                    }
//                    fragmentChooser.hideProgressBlock();
//                }
//                if (response.body() != null) {
//                    updateData(response.body());
//                }
//                fragmentChooser.hideProgressBlock();
//            }
//
//            @Override
//            public void failure(CountryErrorItem countyErrorItem) {
//                if (TextUtils.isEmpty(countyErrorItem.getDocumentation_url())) {
//                    makeErrorToast(countyErrorItem.getMessage());
//                } else {
//                    makeErrorToast(countyErrorItem.getMessage() + ", Details: " + countyErrorItem.getDocumentation_url());
//                }
//                fragmentChooser.hideProgressBlock();
//            }
//
//
//        });
//    }

//    private void updateData(List<CountryItem> list) {
//        getDatabase().countryItemDao().deleteAll();
//        getDatabase().countryItemDao().insert(list);
//        getDatabase().countryItemDao().getAll().observe(this, countryItems -> {
//            fragmentChooser.clearCountryItems();
//            fragmentChooser.addAll(countryItems);
//        });
//    }

//    private void showHistory() {
//        Intent intent = new Intent(this, AddPhone.class);
//        intent.putExtra(Constants.CHOOSE_REQUEST, ApplicationRequestManager.getArrayPRequest(this));
//        startActivityForResult(intent, 1);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode != RESULT_CANCELED) {
//            String result = data.getStringExtra(Constants.CHOOSE_REQUEST);
//            nameCountry.setText(result);
//            loadRepos(result);
//        }
//    }
}

