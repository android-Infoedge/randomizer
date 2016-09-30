package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Currency;
import com.infoedge.jrandomizer.providers.CurrencyProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CurrencyGenerator extends GenerationRule<Currency,String> {
    private CurrencyProvider mProvider;

    public CurrencyGenerator(Currency annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CurrencyProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] currencies = mProvider.provide();
        int randomIndex = getRandom().nextInt(currencies.length);
        return currencies[randomIndex];
    }

}
