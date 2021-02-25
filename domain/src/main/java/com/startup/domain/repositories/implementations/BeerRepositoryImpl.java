package com.startup.domain.repositories.implementations;

import android.os.Build;

import com.startup.data.remote.models.BeerApi;
import com.startup.data.remote.providers.BeerProviderImpl;
import com.startup.domain.converters.BeerConverterImpl;
import com.startup.domain.models.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeerRepositoryImpl {

    private final BeerProviderImpl beerProvider = new BeerProviderImpl();
    private final BeerConverterImpl beerConverter;

    public BeerRepositoryImpl(BeerConverterImpl beerConverter) {
        this.beerConverter = beerConverter;
    }

    public ArrayList<Beer> getBeers(){
        ArrayList<BeerApi> beerApiArrayList = beerProvider.getBeerApiArrayList();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            List<Beer> collect = beerApiArrayList.stream()
                    .map(beerApi -> beerConverter.fromApiToUI(beerApi))
                    .collect(Collectors.toList());

            return (ArrayList<Beer>) collect;
        }
        return null;
    }
}
