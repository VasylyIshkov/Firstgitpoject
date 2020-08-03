package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.classes.CountryItem;

import java.util.List;



@Dao
public interface CountryItemDao {
    @Query("SELECT * FROM countryItemsTable")
    LiveData<List<CountryItem>> getAll();

    @Query("SELECT * FROM countryItemsTable WHERE id = :id")
    LiveData<CountryItem> getById(long id);

    @Insert
    void insert(CountryItem item);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<CountryItem> items);

    @Update
    void update(CountryItem item);

    @Delete
    void delete(CountryItem item);

    @Query("DELETE FROM countryItemsTable")
    void deleteAll();
}
