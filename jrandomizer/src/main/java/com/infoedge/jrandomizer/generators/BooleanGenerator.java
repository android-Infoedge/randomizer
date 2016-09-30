package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.BooleanValue;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class BooleanGenerator extends GenerationRule<BooleanValue,Boolean> {

    public BooleanGenerator(BooleanValue annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public Boolean generate() {
        int random = Utils.randomIntWithMax(5000);
        return random % 2 == 0;
    }
}
