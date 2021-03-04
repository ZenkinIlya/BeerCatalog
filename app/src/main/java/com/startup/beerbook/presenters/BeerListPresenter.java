package com.startup.beerbook.presenters;

import android.os.Handler;
import android.os.Looper;

import com.startup.beerbook.views.BeerListView;
import com.startup.domain.converters.BeerConverterImpl;
import com.startup.domain.models.Beer;
import com.startup.domain.repositories.implementations.BeerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class BeerListPresenter extends MvpPresenter<BeerListView> {

    private final BeerRepositoryImpl repository = new BeerRepositoryImpl(new BeerConverterImpl());

    public void getBeerList(){

        getViewState().presentLoading();
        Observable<List<Beer>> arrayListObservable = repository.getBeers();

        arrayListObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beers -> getViewState().presentBeers((ArrayList<Beer>) beers));

    }
}
