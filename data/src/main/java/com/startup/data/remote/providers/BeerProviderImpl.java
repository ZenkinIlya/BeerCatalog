package com.startup.data.remote.providers;

import com.startup.data.remote.helpers.RetrofitFactory;
import com.startup.data.remote.models.BeerApi;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerProviderImpl {

    public Observable<ArrayList<BeerApi>> getBeerApiArrayList(){
        return RetrofitFactory.getBeerService().getBeers(1, 10);
    }
}
