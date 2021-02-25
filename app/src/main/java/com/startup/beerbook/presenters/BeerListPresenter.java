package com.startup.beerbook.presenters;

import android.os.Handler;
import android.os.Looper;

import com.startup.beerbook.views.BeerListView;
import com.startup.domain.converters.BeerConverterImpl;
import com.startup.domain.models.Beer;
import com.startup.domain.repositories.implementations.BeerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class BeerListPresenter extends MvpPresenter<BeerListView> {

    private BeerRepositoryImpl repository = new BeerRepositoryImpl(new BeerConverterImpl());

    public void getBeerList(){

        getViewState().presentLoading();
        ArrayList<Beer> beers = repository.getBeers();
        getViewState().presentBeers(beers);
    }
}
