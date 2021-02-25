package com.startup.domain.converters;

import com.startup.data.remote.models.BeerApi;
import com.startup.domain.models.Beer;

public class BeerConverterImpl {
    public Beer fromApiToUI(BeerApi beerApi){
        return new Beer(
                beerApi.getId(),
                beerApi.getName(),
                beerApi.getDescription(),
                beerApi.getImageUrl()
        );
    }
}
