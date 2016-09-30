package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.ShirtSize;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.ShirtSizeProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class ShirtSizeGenerator extends GenerationRule<ShirtSize,String> {
    private ShirtSizeProvider mProvider;

    public ShirtSizeGenerator(ShirtSize annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(ShirtSizeProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] sizes = mProvider.provide();
        int randomIndex = getRandom().nextInt(sizes.length);
        return sizes[randomIndex];
    }

}
