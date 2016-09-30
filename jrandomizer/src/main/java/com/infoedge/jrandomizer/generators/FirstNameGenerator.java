package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.FirstName;
import com.infoedge.jrandomizer.providers.FirstNameFemaleProvider;
import com.infoedge.jrandomizer.providers.FirstNameMaleProvider;
import com.infoedge.jrandomizer.providers.FirstNameMixProvider;
import com.infoedge.jrandomizer.providers.Provider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 28/7/16.
 */

public class FirstNameGenerator extends GenerationRule<FirstName, String> {

    private Provider<String[]> mProvider;

    public FirstNameGenerator(FirstName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = loadProvider(annotation.gender());
    }

    @Override
    public String generate() {
        String[] firstNames = mProvider.provide();
        int random = getRandom().nextInt(firstNames.length);
        return firstNames[random];
    }

    private Provider<String[]> loadProvider(FirstName.Gender gender) {
        switch (gender) {
            case MIX:
                return ProviderFactory.getInstance().provider(FirstNameMixProvider.class, String[].class);
            case MALE:
                return ProviderFactory.getInstance().provider(FirstNameMaleProvider.class, String[].class);
            case FEMALE:
                return ProviderFactory.getInstance().provider(FirstNameFemaleProvider.class, String[].class);
        }
        return ProviderFactory.getInstance().provider(FirstNameMixProvider.class, String[].class);
    }
}
