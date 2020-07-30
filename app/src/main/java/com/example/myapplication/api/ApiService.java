package com.example.myapplication.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
//надо с эти разобраться
public interface ApiService {
    //???
    @GET("/rest/v2/name/")
    Call<GitResponse> getUserRepos(@Query("q") String query);
}
