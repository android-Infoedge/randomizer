package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.HexColor;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class HexColorGenerator extends GenerationRule<HexColor,String> {

    public HexColorGenerator(HexColor annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        String alpha = "";
        if (getAnnotation().alpha()) {
            alpha = toHex(getRandom().nextInt(256));
        }
        String red = toHex(getRandom().nextInt(256));
        String green = toHex(getRandom().nextInt(256));
        String blue = toHex(getRandom().nextInt(256));
        String hexCode = String.format("#%s%s%s%s", alpha, red, green, blue);
        return getAnnotation().upperCase() ? hexCode.toUpperCase() : hexCode.toLowerCase();
    }

    private String toHex(int integer) {
        String hexString = Integer.toHexString(integer);
        switch (hexString.length()) {
            case 0:
                hexString = "00";
                break;
            case 1:
                hexString = "0" + hexString;
                break;
        }
        return hexString;
    }
}
