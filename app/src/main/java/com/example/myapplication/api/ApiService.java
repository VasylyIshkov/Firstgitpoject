package com.example.myapplication.api;

import com.example.myapplication.classes.CountryItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    @GET("/rest/v2/name/{name}")
    Call<List<CountryItem>> getUserRepos(@Path("name") String query);
}
