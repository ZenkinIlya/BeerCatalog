package com.startup.domain.repositories.implementations;

import android.os.Build;
import android.util.Log;

import com.startup.data.remote.models.BeerApi;
import com.startup.data.remote.providers.BeerProviderImpl;
import com.startup.domain.converters.BeerConverterImpl;
import com.startup.domain.models.Beer;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableToList;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BeerRepositoryImpl {

    private static final String TAG = "TgBeerRepo";
    private final BeerProviderImpl beerProvider = new BeerProviderImpl();
    private final BeerConverterImpl beerConverter;

    public BeerRepositoryImpl(BeerConverterImpl beerConverter) {
        this.beerConverter = beerConverter;
    }

    public Observable<List<Beer>> getBeers(){
        Observable<List<BeerApi>> beerApiArrayList = beerProvider.getBeerApiArrayList();

        return beerApiArrayList
                .doOnNext(beerApis -> Log.d(TAG, "getBeers: doOnNext"))
                .concatMap(beerApis -> Observable.fromIterable(beerApis))
                .map(beerApi -> beerConverter.fromApiToUI(beerApi))
                .toList()
                .toObservable();

    }
}
