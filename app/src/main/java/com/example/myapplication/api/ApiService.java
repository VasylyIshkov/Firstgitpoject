package com.example.myapplication.api;

import com.example.myapplication.classes.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//надо с эти разобраться
public interface ApiService {
    //???
    @GET("/rest/v2/name/")
    Call<CountryResponse> getUserRepos(@Query("q") String query);
}
