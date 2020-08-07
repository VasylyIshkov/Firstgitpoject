package com.example.myapplication.base;

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showProgress();

    void hideProgress();

    void hideKeyboard();
}
