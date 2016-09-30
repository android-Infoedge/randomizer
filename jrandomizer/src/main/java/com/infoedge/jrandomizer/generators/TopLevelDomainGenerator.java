package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.TopLevelDomain;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.TopLevelDomainProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class TopLevelDomainGenerator extends GenerationRule<TopLevelDomain,String> {

    private TopLevelDomainProvider mProvider;

    public TopLevelDomainGenerator(TopLevelDomain annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(TopLevelDomainProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] domains = mProvider.provide();
        int randomIndex = getRandom().nextInt(domains.length);
        return domains[randomIndex];
    }
}
