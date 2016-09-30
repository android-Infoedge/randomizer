package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.IpAddressV4;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class IpAddressV4Generator extends GenerationRule<IpAddressV4, String> {

    public IpAddressV4Generator(IpAddressV4 annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        return String.format("%s.%s.%s.%s", Utils.randomIntWithMax(256), Utils.randomIntWithMax(256), Utils.randomIntWithMax(256), Utils.randomIntWithMax(256));
    }

}
