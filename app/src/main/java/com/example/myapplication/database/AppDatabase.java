package com.example.myapplication.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.classes.CountryResponse;

@Database(entities = {CountryItem.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CountryItemDao countryItemDao();
}
