package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.MacAddress;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class MacAddressGenerator extends GenerationRule<MacAddress, String> {

    public MacAddressGenerator(MacAddress annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        String macAddress = String.format("%s-%s-%s-%s-%s-%s"
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
                , Utils.frontPad(Utils.randomHexOfInt(256),"0",2)
        );
        return macAddress.toUpperCase();
    }

}
