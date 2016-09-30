package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.StreetAddress;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.StreetAddressProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class StreetAddressGenerator extends GenerationRule<StreetAddress,String> {
    private StreetAddressProvider mProvider;

    public StreetAddressGenerator(StreetAddress annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(StreetAddressProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] streetAddresses = mProvider.provide();
        int randomIndex = getRandom().nextInt(streetAddresses.length);
        return streetAddresses[randomIndex];
    }

}
