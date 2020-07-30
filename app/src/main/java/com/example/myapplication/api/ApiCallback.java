package com.example.myapplication.api;

import com.example.myapplication.classes.CountryErrorItem;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<T> {

    public abstract void success(Response<T> response);

    public abstract void failure(CountryErrorItem countyErrorItem);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (!response.isSuccessful()) {

            Converter<ResponseBody, CountryErrorItem> converter = RestClient.getsIstance().getRetrofit().responseBodyConverter(CountryErrorItem.class, new Annotation[0]);
            try {
                CountryErrorItem countryErrorItem = converter.convert(response.errorBody());
                failure(countryErrorItem);
            } catch (Exception ex) {
                failure(new CountryErrorItem("Unhandled error! Code: " + response.code()));
            }
        } else {
            success(response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure(new CountryErrorItem("Unexpected error! Code: " + t.getMessage()));
    }
}
