package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.Gender;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class GenderGenerator extends GenerationRule<Gender,String> {

    public GenderGenerator(Gender annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        int random = Utils.randomIntWithMax(5000);
        return random % 2 == 0 ? getAnnotation().abbreviation() ? "M" : "Male" : getAnnotation().abbreviation() ? "F" :"Female";
    }
}
