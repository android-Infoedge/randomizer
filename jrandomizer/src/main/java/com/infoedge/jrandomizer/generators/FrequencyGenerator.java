package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Frequency;
import com.infoedge.jrandomizer.providers.FrequencyProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class FrequencyGenerator extends GenerationRule<Frequency,String> {

    private FrequencyProvider mProvider;

    public FrequencyGenerator(Frequency annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(FrequencyProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] frequencies = mProvider.provide();
        int length = frequencies.length;
        int random = getRandom().nextInt(length);
        return frequencies[random];
    }
}
