package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.ColorName;
import com.infoedge.jrandomizer.providers.ColorNameProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class ColorNameGenerator extends GenerationRule<ColorName, String> {

    private ColorNameProvider mProvider;

    public ColorNameGenerator(ColorName annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(ColorNameProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] colorNames = mProvider.provide();
        int index = getRandom().nextInt(colorNames.length);
        return colorNames[index];
    }

}
