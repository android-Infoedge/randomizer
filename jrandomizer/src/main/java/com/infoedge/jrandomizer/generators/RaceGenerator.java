package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Race;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.RaceProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class RaceGenerator extends GenerationRule<Race,String> {
    private RaceProvider mProvider;

    public RaceGenerator(Race annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(RaceProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] races = mProvider.provide();
        int randomIndex = getRandom().nextInt(races.length);
        return races[randomIndex];
    }

}
