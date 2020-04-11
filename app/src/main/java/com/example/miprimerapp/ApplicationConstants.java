package com.example.miprimerapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationConstants {
    public static final String BASE_URL="http://www.msrv.com:8443/";
    public static <T> T getRetrofitBuilder (final Class<T> service){
        Gson gson=new GsonBuilder()
                .setDateFormat("yyyy-mm-dd'T'hh:mm:ssZ")
                .create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(service);
    }
}
