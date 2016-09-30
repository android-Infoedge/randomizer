package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.CreditCardNumber;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CreditCardNumberGenerator extends GenerationRule<CreditCardNumber,String> {

    private String mSeparator;

    public CreditCardNumberGenerator(CreditCardNumber annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        String separator = annotation.separator();
        mSeparator = separator == null || separator.length() == 0 ? "" : separator.substring(0, 1);
    }

    @Override
    public String generate() {
        StringBuilder cardNumberBuilder = new StringBuilder();
        cardNumberBuilder.append(Utils.frontPad(String.valueOf(Utils.randomIntWithMinMax(1000, 10001)), "0", 4)).append(mSeparator);
        cardNumberBuilder.append(Utils.frontPad(String.valueOf(Utils.randomIntWithMinMax(0, 10001)), "0", 4)).append(mSeparator);
        cardNumberBuilder.append(Utils.frontPad(String.valueOf(Utils.randomIntWithMinMax(0, 10001)), "0", 4)).append(mSeparator);
        cardNumberBuilder.append(Utils.frontPad(String.valueOf(Utils.randomIntWithMinMax(0, 10001)), "0", 4));
        return cardNumberBuilder.toString();
    }


}
