package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.lang.annotation.Annotation;
import java.util.Random;

/**
 * Created by gagandeep on 28/7/16.
 */

public abstract class GenerationRule<RANDOM_GENERATOR_ANNOTATION extends Annotation, TARGET_DATA_TYPE> {

    protected RANDOM_GENERATOR_ANNOTATION mGeneratorAnnotation;
    private Random mRandom;
    private ProviderFactory mProviderFactory;

    public GenerationRule(RANDOM_GENERATOR_ANNOTATION annotation, ProviderFactory providerFactory) {
        this.mGeneratorAnnotation = annotation;
        mRandom = new Random();
        this.mProviderFactory = providerFactory;
    }

    public abstract TARGET_DATA_TYPE generate();

    public Random getRandom() {
        return mRandom;
    }

    public RANDOM_GENERATOR_ANNOTATION getAnnotation() {
        return mGeneratorAnnotation;
    }

    public ProviderFactory providerFactory() {
        return mProviderFactory;
    }

}
