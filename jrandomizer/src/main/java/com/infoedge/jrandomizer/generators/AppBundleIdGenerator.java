package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.AppBundleID;
import com.infoedge.jrandomizer.providers.AppBundleIdProvider;
import com.infoedge.jrandomizer.providers.AppBundleIdProvider.AppBundleIdData;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class AppBundleIdGenerator extends GenerationRule<AppBundleID, String> {

    private AppBundleIdProvider mProvider;

    public AppBundleIdGenerator(AppBundleID annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(AppBundleIdProvider.class, AppBundleIdData.class);
    }

    @Override
    public String generate() {
        AppBundleIdData bundleIdData = mProvider.provide();
        String tld = getRandomPart(bundleIdData.tlds);
        String companyName = getRandomPart(bundleIdData.companyNames);
        String productName = getRandomPart(bundleIdData.productNames);
        return String.format("%s.%s.%s", tld, companyName, productName);
    }

    private String getRandomPart(String[] data) {
        int randomIndex = getRandom().nextInt(data.length);
        return data[randomIndex];
    }


}
