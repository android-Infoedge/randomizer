package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CountryCode;
import com.infoedge.jrandomizer.providers.CountryCodeProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CountryCodeGenerator extends GenerationRule<CountryCode,String> {
    private CountryCodeProvider mProvider;

    public CountryCodeGenerator(CountryCode annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CountryCodeProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] countries = mProvider.provide();
        int randomIndex = getRandom().nextInt(countries.length);
        return countries[randomIndex];
    }

}
