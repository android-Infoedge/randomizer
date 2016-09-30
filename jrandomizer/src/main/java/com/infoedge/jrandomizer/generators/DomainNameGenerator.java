package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.DomainName;
import com.infoedge.jrandomizer.providers.DomainNameProvider;
import com.infoedge.jrandomizer.providers.DomainNameProvider.DomainNameData;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class DomainNameGenerator extends GenerationRule<DomainName,String> {

    private DomainNameProvider mProvider;

    public DomainNameGenerator(DomainName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(DomainNameProvider.class, DomainNameData.class);
    }

    @Override
    public String generate() {
        DomainNameData domainNameData = mProvider.provide();
        String topLevelDomain = domainNameData.topLevelDomains[getRandom().nextInt(domainNameData.topLevelDomains.length)];
        String subDomain = domainNameData.subDomains[getRandom().nextInt(domainNameData.subDomains.length)];
        return String.format("%s.%s", subDomain, topLevelDomain);
    }
}
