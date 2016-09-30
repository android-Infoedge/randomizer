package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Country;
import com.infoedge.jrandomizer.providers.CountryProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CountryGenerator extends GenerationRule<Country,String> {
    private CountryProvider mProvider;

    public CountryGenerator(Country annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CountryProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] countries = mProvider.provide();
        int randomIndex = getRandom().nextInt(countries.length);
        return countries[randomIndex];
    }

}
