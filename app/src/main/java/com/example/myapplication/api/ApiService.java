package com.example.myapplication.api;

import com.example.myapplication.classes.CountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//надо с эти разобраться
public interface ApiService {
    //???
    @GET("/rest/v2/name/{name}")
    Call<List<CountryResponse>> getUserRepos(@Path("name") String query);
}
