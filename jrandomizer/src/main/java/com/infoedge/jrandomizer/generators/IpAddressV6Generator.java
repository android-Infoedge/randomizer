package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.IpAddressV6;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class IpAddressV6Generator extends GenerationRule<IpAddressV6, String> {

    public IpAddressV6Generator(IpAddressV6 annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        String ipV6Address = String.format("%s.%s.%s.%s.%s.%s"
                , Utils.randomHexOfInt(65536)
                , Utils.randomHexOfInt(65536)
                , Utils.randomHexOfInt(65536)
                , Utils.randomHexOfInt(65536)
                , Utils.randomHexOfInt(65536)
                , Utils.randomHexOfInt(65536)
        );
        return ipV6Address;
    }

}
