package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.City;
import com.infoedge.jrandomizer.providers.CityProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CityGenerator extends GenerationRule<City,String> {
    private CityProvider mProvider;

    public CityGenerator(City annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CityProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] cities = mProvider.provide();
        int randomIndex = getRandom().nextInt(cities.length);
        return cities[randomIndex];
    }

}
