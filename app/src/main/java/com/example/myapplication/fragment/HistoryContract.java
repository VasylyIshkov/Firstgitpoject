package com.example.myapplication.fragment;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;

import java.util.ArrayList;

public interface HistoryContract {
    interface View extends BaseView<Presenter> {
        void showInfo();
    }

    interface Presenter extends BasePresenter<View> {
        ArrayList<String> getItems();
    }
}

