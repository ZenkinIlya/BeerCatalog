package com.startup.data.remote.services;

import com.startup.data.remote.models.BeerApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerService {
    @GET("beers")
    public Call<ArrayList<BeerApi>> getBeers(@Query("page") int page, @Query("per_page") int per_page);
}