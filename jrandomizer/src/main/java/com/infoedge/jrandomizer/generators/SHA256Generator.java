package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.SHA256;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SHA256Generator extends GenerationRule<SHA256,String> {

    public SHA256Generator(SHA256 annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        StringBuilder hashBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            hashBuilder.append(Utils.frontPad(Utils.randomHexOfLong(4294967296L), "0", 8));
        }
        return hashBuilder.toString();
    }
}
