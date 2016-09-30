package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.TimeZone;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.TimeZoneProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class TimeZoneGenerator extends GenerationRule<TimeZone,String> {
    private TimeZoneProvider mProvider;

    public TimeZoneGenerator(TimeZone annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(TimeZoneProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] timeZones = mProvider.provide();
        int randomIndex = getRandom().nextInt(timeZones.length);
        return timeZones[randomIndex];
    }

}
