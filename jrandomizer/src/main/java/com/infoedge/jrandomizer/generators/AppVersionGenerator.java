package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.AppVersion;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class AppVersionGenerator extends GenerationRule<AppVersion,String> {

    private int minVersion;
    private int maxVersion;

    public AppVersionGenerator(AppVersion annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        minVersion = annotation.min();
        maxVersion = annotation.max();
        if (maxVersion < minVersion) {
            maxVersion = minVersion;
        }
    }

    @Override
    public String generate() {
        int majorVersion = minVersion + getRandom().nextInt((maxVersion - minVersion) + 1);
        int parts = getRandom().nextInt(3);
        StringBuilder appVersion = new StringBuilder(String.valueOf(majorVersion));
        for (int i = 0; i < parts; i++) {
            int subversion = getRandom().nextInt(10);
            appVersion.append(".").append(subversion);
        }
        return appVersion.toString();
    }
}
