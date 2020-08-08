package com.example.myapplication.fragment;

import android.net.Uri;

import com.bumptech.glide.RequestBuilder;

public class ViewerPresenter implements ViewerContract.Presenter {

    private ViewerContract.View view;
    private String url;
    private String info;


    @Override
    public void setData(String url, String info) {
        this.url=url;
        this.info = info;
    }

    @Override
    public Uri getUri() {
       Uri uri = Uri.parse(url);
       return uri;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void takeView(ViewerContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }
}
