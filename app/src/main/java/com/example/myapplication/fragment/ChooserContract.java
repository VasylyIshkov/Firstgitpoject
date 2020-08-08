package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.classes.CountryItem;

import java.util.List;

public interface ChooserContract {
    interface View extends BaseView<Presenter> {
        void showProgress();

        void hideProgress();

        void hideKeyboard();

        void showInputError();

        void showRequestError(@NonNull String message);

        void observeItems(LiveData<List<CountryItem>> itemsLiveData);

        void stopObserving(LiveData<List<CountryItem>> liveRepoData);
    }

    interface Presenter extends BasePresenter<View> {

        void searchRepos(@NonNull String query);

        ApplicationRequestManager getManager();
    }
}
