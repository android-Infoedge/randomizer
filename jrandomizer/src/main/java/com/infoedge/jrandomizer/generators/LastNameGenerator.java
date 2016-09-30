package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.LastName;
import com.infoedge.jrandomizer.providers.FullNameProvider;
import com.infoedge.jrandomizer.providers.FullNameProvider.FullNameData;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class LastNameGenerator extends GenerationRule<LastName,String> {

    private FullNameProvider mProvider;

    public LastNameGenerator(LastName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(FullNameProvider.class, FullNameData.class);
    }

    @Override
    public String generate() {
        FullNameData fullNameData = mProvider.provide();
        int randomIndex = getRandom().nextInt(fullNameData.lastNames.length);
        String lastName = fullNameData.lastNames[randomIndex];
        return lastName;
    }
}
