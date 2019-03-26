package com.example.demoviewmodel;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
