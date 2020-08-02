package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;
import com.example.myapplication.utils.KeyboardUtils;

import java.util.List;

import retrofit2.Response;


public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    private RecyclerView recyclerView;
    private boolean inLandscapeMode;
    private AppCompatEditText nameCountry;
    private AppCompatButton startSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(getString(R.string.main_activity_title));
        initHistoryButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHistory();
            }
        });
        inLandscapeMode = findViewById(R.id.fragment_viewer) != null;
        fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_chooser);
        nameCountry = findViewById(R.id.country_name);
        nameCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    search();
                    return true;
                }
                return false;
            }
        });
        startSearch = findViewById(R.id.start_search);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
        recyclerView = findViewById(R.id.recycler_view);
        OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener = new OnCountryRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                displaySelected(fragmentChooser.getItem(position));
            }
        };
        fragmentChooser.setOnCountryRecyclerItemClickListener(onCountryRecyclerItemClickListener);
        if (inLandscapeMode) {
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        }


    }


    private void displaySelected(CountryItem countryItem) {
        if (inLandscapeMode) {
            fragmentViewer.displayResorce(countryItem);
        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(Constants.COUNTRY_INFO, countryItem.getInfo());
            intent.putExtra(Constants.FLAG_URI, countryItem.getFlag());
            startActivity(intent);
        }
    }

    private void search() {
        if (TextUtils.isEmpty(nameCountry.getText().toString())) {
            nameCountry.requestFocus();
        } else {
            KeyboardUtils.hide(nameCountry);
            loadRepos(nameCountry.getText().toString());
        }
    }

    private void makeErrorToast(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void loadRepos(String countryName) {
        ApplicationRequestManager.setRequest(nameCountry.getText().toString(), this);
        fragmentChooser.showProgressBlock();
        RestClient.getsIstance().getApiService().getUserRepos(countryName).enqueue(new ApiCallback<List<CountryItem>>() {


            @Override
            public void success(Response<List<CountryItem>> response) {
                if (!response.isSuccessful()) {
                    if (response.body() != null) {
                        fragmentChooser.clearCountryItems();
                        fragmentChooser.addAll(response.body());
                    }
                    fragmentChooser.hideProgressBlock();
                }
                if (response.body() != null) {
                    fragmentChooser.clearCountryItems();
                    fragmentChooser.addAll(response.body());
                }
                fragmentChooser.hideProgressBlock();
            }

            @Override
            public void failure(CountryErrorItem countyErrorItem) {
                if (TextUtils.isEmpty(countyErrorItem.getDocumentation_url())) {
                    makeErrorToast(countyErrorItem.getMessage());
                } else {
                    makeErrorToast(countyErrorItem.getMessage() + ", Details: " + countyErrorItem.getDocumentation_url());
                }
                fragmentChooser.hideProgressBlock();
            }


        });
    }

    private void showHistory() {
        Intent intent = new Intent(this, AddPhone.class);
        intent.putExtra(Constants.CHOOSE_REQUEST, ApplicationRequestManager.getArrayPRequest(this));
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            String result = data.getStringExtra(Constants.CHOOSE_REQUEST);
            nameCountry.setText(result);
            loadRepos(result);
        }
    }
}

