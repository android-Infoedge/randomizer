package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.lang.annotation.Annotation;
import java.util.Random;

/**
 * Created by gagandeep on 28/7/16.
 */

public abstract class DelegateGenerationRule<RANDOM_GENERATOR_ANNOTATION extends Annotation, TARGET_DATA_TYPE> extends GenerationRule<RANDOM_GENERATOR_ANNOTATION, TARGET_DATA_TYPE> {

    private GenerationRule<RANDOM_GENERATOR_ANNOTATION, String> mCoreGenerator;

    public DelegateGenerationRule(RANDOM_GENERATOR_ANNOTATION annotation, ProviderFactory providerFactory, GenerationRule<RANDOM_GENERATOR_ANNOTATION, String> mCoreGenerator) {
        super(annotation, providerFactory);
        this.mCoreGenerator = mCoreGenerator;
    }

    public String getCoreRandomData() {
        return mCoreGenerator.generate();
    }

    public abstract TARGET_DATA_TYPE generate();

}
