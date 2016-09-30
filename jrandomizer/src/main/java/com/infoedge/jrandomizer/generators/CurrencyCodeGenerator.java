package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CurrencyCode;
import com.infoedge.jrandomizer.providers.CurrencyCodeProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CurrencyCodeGenerator extends GenerationRule<CurrencyCode,String> {
    private CurrencyCodeProvider mProvider;

    public CurrencyCodeGenerator(CurrencyCode annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CurrencyCodeProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] currencyCodes = mProvider.provide();
        int randomIndex = getRandom().nextInt(currencyCodes.length);
        return currencyCodes[randomIndex];
    }

}
