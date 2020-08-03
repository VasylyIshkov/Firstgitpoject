package com.example.myapplication.database;

import android.net.Uri;

import androidx.room.TypeConverter;

public class UriConverter {
    @TypeConverter
    public String fromUri(Uri uri) {
        return uri.toString();
    }

    @TypeConverter
    public Uri toUri(String uri) {
        return Uri.parse(uri);
    }
}
