package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.FullName;
import com.infoedge.jrandomizer.providers.FullNameProvider;
import com.infoedge.jrandomizer.providers.FullNameProvider.FullNameData;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class FullNameGenerator extends GenerationRule<FullName,String> {

    private FullNameProvider mProvider;

    public FullNameGenerator(FullName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(FullNameProvider.class, FullNameData.class);
    }

    @Override
    public String generate() {
        FullNameData fullNameData = mProvider.provide();
        int randomIndex = getRandom().nextInt(fullNameData.firstNames.length);
        String firstName = fullNameData.firstNames[randomIndex];
        randomIndex = getRandom().nextInt(fullNameData.lastNames.length);
        String lastName = fullNameData.lastNames[randomIndex];
        return String.format("%s %s",firstName,lastName);
    }
}
