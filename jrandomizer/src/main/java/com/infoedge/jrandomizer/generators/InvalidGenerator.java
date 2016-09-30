package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CustomGenerator;
import com.infoedge.jrandomizer.exceptions.RandomDataGeneratorException;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 1/8/16.
 */

public class InvalidGenerator extends GenerationRule<CustomGenerator,Void> {

    public InvalidGenerator(CustomGenerator annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public Void generate() {
        String message = String.format("%s cannot generate anything for %s", this.getClass().getSimpleName(), getAnnotation().getClass().getSimpleName());
        throw new RandomDataGeneratorException(message);
    }
}
