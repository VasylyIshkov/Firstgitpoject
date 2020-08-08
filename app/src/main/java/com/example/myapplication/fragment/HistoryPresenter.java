package com.example.myapplication.fragment;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication.Constants;

import java.util.ArrayList;

public class HistoryPresenter implements HistoryContract.Presenter {
    private HistoryContract.View view;
    private Intent intent;

    public HistoryPresenter(Intent intent) {
        this.intent = intent;
    }

    @Override
    public ArrayList<String> getItems() {
        Log.println(Log.DEBUG, "Errr", "Req_arr");
        return intent.getStringArrayListExtra(Constants.CHOOSE_REQUEST);
    }

    @Override
    public void takeView(HistoryContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }
}
