package com.example.myapplication.fragment;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.classes.CountryItem;

import java.util.List;

public interface ViewerContract {
    interface View extends BaseView<ViewerContract.Presenter> {

        void showInfo();
    }

    interface Presenter extends BasePresenter<ViewerContract.View> {

        void setData(String url,String info);
        Uri getUri();
        String getInfo();
    }
}
