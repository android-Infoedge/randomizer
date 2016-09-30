package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Guid;
import com.infoedge.jrandomizer.providers.GuidProvider;
import com.infoedge.jrandomizer.providers.GuidProvider.GuidRecord;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class GuidGenerator extends GenerationRule<Guid, String> {

    private GuidProvider mProvider;
    private boolean mEssentiallyUnique;
    private String firstPart = null;

    public GuidGenerator(Guid annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(GuidProvider.class, GuidRecord[].class);
        mEssentiallyUnique = annotation.essentiallyUnique();
    }

    @Override
    public String generate() {
        GuidRecord[] guids = mProvider.provide();
        int random = getRandom().nextInt(guids.length);
        GuidRecord randomGuid = guids[random];
        if (mEssentiallyUnique) {
            if (firstPart == null) {
                firstPart = randomGuid.firstPart;
            }
        } else {
            firstPart = randomGuid.firstPart;
        }
        return firstPart + randomGuid.lastPart;
    }

}
