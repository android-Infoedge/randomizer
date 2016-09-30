package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Latitude;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class LatitudeGenerator extends GenerationRule<Latitude,String> {

    public LatitudeGenerator(Latitude annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        return String.valueOf((getRandom().nextDouble() * -180.0) + 90.0);
    }
}
