package com.example.myapplication.fragment;

import android.net.Uri;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;

public interface ViewerContract {
    interface View extends BaseView<ViewerContract.Presenter> {

        void showInfo();
    }

    interface Presenter extends BasePresenter<ViewerContract.View> {

        void setData(String url, String info);

        Uri getUri();

        String getInfo();
    }
}
