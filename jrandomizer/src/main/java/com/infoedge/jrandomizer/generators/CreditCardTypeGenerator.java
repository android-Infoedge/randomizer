package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CreditCardType;
import com.infoedge.jrandomizer.providers.CreditCardTypeProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CreditCardTypeGenerator extends GenerationRule<CreditCardType,String> {
    private CreditCardTypeProvider mProvider;

    public CreditCardTypeGenerator(CreditCardType annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CreditCardTypeProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] cardTypes = mProvider.provide();
        int randomIndex = getRandom().nextInt(cardTypes.length);
        return cardTypes[randomIndex];
    }

}
