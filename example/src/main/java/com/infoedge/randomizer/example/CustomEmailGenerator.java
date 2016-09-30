package com.infoedge.randomizer.example;

import com.infoedge.jrandomizer.annotations.Email;
import com.infoedge.jrandomizer.generators.DelegateGenerationRule;
import com.infoedge.jrandomizer.generators.GenerationRule;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 12/8/16.
 */

public class CustomEmailGenerator extends DelegateGenerationRule<Email,String> {

    public CustomEmailGenerator(Email annotation, ProviderFactory providerFactory, GenerationRule<Email, String> mCoreGenerator) {
        super(annotation, providerFactory, mCoreGenerator);
    }

    @Override
    public String generate() {
        return getCoreRandomData().toUpperCase();
    }
}
