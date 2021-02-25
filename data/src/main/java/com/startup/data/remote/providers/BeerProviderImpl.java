package com.startup.data.remote.providers;

import com.startup.data.remote.helpers.RetrofitFactory;
import com.startup.data.remote.models.BeerApi;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerProviderImpl {

    public ArrayList<BeerApi> getBeerApiArrayList(){
        ArrayList<BeerApi> result = new ArrayList<>();

        RetrofitFactory.getBeerService().getBeers(1, 10).enqueue(new Callback<ArrayList<BeerApi>>() {
            @Override
            public void onResponse(Call<ArrayList<BeerApi>> call, Response<ArrayList<BeerApi>> response) {
                result.addAll(Objects.requireNonNull(response.body()));
            }

            @Override
            public void onFailure(Call<ArrayList<BeerApi>> call, Throwable t) {

            }
        });
        return result;
    }
}
