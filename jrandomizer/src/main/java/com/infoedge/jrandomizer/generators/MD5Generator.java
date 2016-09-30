package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.MD5;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class MD5Generator extends GenerationRule<MD5,String> {

    public MD5Generator(MD5 annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        StringBuilder hashBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            hashBuilder.append(Utils.frontPad(Utils.randomHexOfInt(65536), "0", 4));
        }
        return hashBuilder.toString();
    }
}
