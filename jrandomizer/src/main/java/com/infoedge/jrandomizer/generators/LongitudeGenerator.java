package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Longitude;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class LongitudeGenerator extends GenerationRule<Longitude,String> {

    public LongitudeGenerator(Longitude annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        return String.valueOf((getRandom().nextDouble() * -360.0) + 180.0);
    }
}
