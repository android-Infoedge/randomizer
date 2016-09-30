package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Title;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.TitleProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class TitleGenerator extends GenerationRule<Title,String> {
    private TitleProvider mProvider;

    public TitleGenerator(Title annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(TitleProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] titles = mProvider.provide();
        int randomIndex = getRandom().nextInt(titles.length);
        return titles[randomIndex];
    }

}
