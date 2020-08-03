package com.example.myapplication.app;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.database.AppDatabase;

public class FirstProjectApp extends Application {
    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "countryitems")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
