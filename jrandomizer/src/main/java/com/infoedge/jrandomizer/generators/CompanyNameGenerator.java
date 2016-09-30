package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CompanyName;
import com.infoedge.jrandomizer.providers.CompanyNameProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CompanyNameGenerator extends GenerationRule<CompanyName,String> {

    private CompanyNameProvider mProvider;

    public CompanyNameGenerator(CompanyName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CompanyNameProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] companyNames = mProvider.provide();
        int randomIndex = getRandom().nextInt(companyNames.length);
        return companyNames[randomIndex];
    }

}
