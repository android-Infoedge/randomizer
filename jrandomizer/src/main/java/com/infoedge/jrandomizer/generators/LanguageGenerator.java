package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Language;
import com.infoedge.jrandomizer.providers.LanguageProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class LanguageGenerator extends GenerationRule<Language,String> {
    private LanguageProvider mProvider;

    public LanguageGenerator(Language annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(LanguageProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] languages = mProvider.provide();
        int randomIndex = getRandom().nextInt(languages.length);
        return languages[randomIndex];
    }

}
