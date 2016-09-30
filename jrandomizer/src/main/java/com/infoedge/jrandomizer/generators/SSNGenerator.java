package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.SSN;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SSNGenerator extends GenerationRule<SSN, String> {


    public SSNGenerator(SSN annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        int firstNumber = Utils.randomIntWithMinMax(100,1001);
        int secondNumber = Utils.randomIntWithMinMax(10,101);
        int thirdNumber = Utils.randomIntWithMinMax(1000,10001);
        return String.format("%d-%d-%d", firstNumber, secondNumber, thirdNumber);
    }
}
