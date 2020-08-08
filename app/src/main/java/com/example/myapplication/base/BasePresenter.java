package com.example.myapplication.base;

public interface BasePresenter<T> {
    void takeView(T view);

    void dropView();
}
