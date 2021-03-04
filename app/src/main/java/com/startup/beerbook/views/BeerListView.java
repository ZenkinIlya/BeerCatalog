package com.startup.beerbook.views;

import com.startup.domain.models.Beer;

import java.util.ArrayList;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BeerListView extends MvpView {
    void presentBeers(ArrayList<Beer> beerArrayList);
    void presentLoading();
    void presentToast(String message);
}
