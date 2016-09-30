package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Suffix;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.SuffixProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SuffixGenerator extends GenerationRule<Suffix,String> {
    private SuffixProvider mProvider;

    public SuffixGenerator(Suffix annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(SuffixProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] suffixes = mProvider.provide();
        int randomIndex = getRandom().nextInt(suffixes.length);
        return suffixes[randomIndex];
    }

}
