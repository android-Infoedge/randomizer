package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.SHA1;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SHA1Generator extends GenerationRule<SHA1,String> {

    public SHA1Generator(SHA1 annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        StringBuilder hashBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            hashBuilder.append(Utils.frontPad(Utils.randomHexOfInt(65536), "0", 4));
        }
        return hashBuilder.toString();
    }
}
