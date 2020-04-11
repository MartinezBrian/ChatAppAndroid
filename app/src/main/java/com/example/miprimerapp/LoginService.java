package com.example.miprimerapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("UserLogin")
    Call <User> SingUp (@Body User user);
}
