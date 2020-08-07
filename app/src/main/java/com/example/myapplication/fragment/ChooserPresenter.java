package com.example.myapplication.fragment;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.myapplication.api.ApiCallback;
import com.example.myapplication.api.RestClient;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.classes.CountryErrorItem;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.database.AppDatabase;

import java.util.List;

import retrofit2.Response;

public class ChooserPresenter implements ChooserContract.Presenter {
    private ChooserContract.View view;
    private ApplicationRequestManager manager;
    private AppDatabase database;
    private LiveData<List<CountryItem>> liveData;

    public ChooserPresenter(ApplicationRequestManager manager, AppDatabase database) {
        this.manager = manager;
        this.database = database;
    }

    @Override
    public void searchRepos(@NonNull String query) {
        if (query.trim().isEmpty()) {
            view.showInputError();
            return;
        }

        view.hideKeyboard();
        view.showProgress();

        OnRequestFinishedListener onRequestFinishedListener = new OnRequestFinishedListener() {
            @Override
            public void onRequestFinished(@Nullable CountryErrorItem errorItem) {
                view.hideProgress();
                if (errorItem != null) {
                    view.showRequestError(errorItem.getMessage() + "; " + errorItem.getDocumentation_url());
                }
            }
        };

        RestClient.getsIstance().getApiService().getUserRepos(query).enqueue(new ApiCallback<List<CountryItem>>() {

            @Override
            public void success(Response<List<CountryItem>> response) {
                cacheItems(response.body());
                onRequestFinishedListener.onRequestFinished(null);
            }

            @Override
            public void failure(CountryErrorItem countyErrorItem) {
                onRequestFinishedListener.onRequestFinished(countyErrorItem);
            }


        });
    }

    private void cacheItems(List<CountryItem> items) {
        database.countryItemDao().deleteAll();
        database.countryItemDao().insert(items);
    }

    @Override
    public void takeView(ChooserContract.View view) {
        this.view = view;
        liveData = database.countryItemDao().getAll();
        view.observeItems(liveData);
    }

    @Override
    public void dropView() {
        view.stopObserving(liveData);
        this.view = null;
        liveData = null;
    }

    interface OnRequestFinishedListener {

        void onRequestFinished(@Nullable CountryErrorItem errorItem);

    }
}
