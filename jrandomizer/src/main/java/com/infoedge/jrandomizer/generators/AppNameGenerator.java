package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.AppName;
import com.infoedge.jrandomizer.providers.AppNameProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class AppNameGenerator extends GenerationRule<AppName, String> {

    private AppNameProvider mProvider;

    public AppNameGenerator(AppName annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(AppNameProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] appNames = mProvider.provide();
        return appNames[getRandom().nextInt(appNames.length)];
    }
}
