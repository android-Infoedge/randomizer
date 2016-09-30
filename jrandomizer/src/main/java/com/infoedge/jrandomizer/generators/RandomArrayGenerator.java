package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;
import com.infoedge.jrandomizer.annotations.CollectionDescriptor;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gagandeep on 2/8/16.
 */

public class RandomArrayGenerator<T> extends GenerationRule<CollectionDescriptor, Object> {

    private int min;
    private int max;
    private ConversionAdapter mConversionAdapter;
    private GenerationRule mGenerationRule;
    private Class<?> mClazz;

    public RandomArrayGenerator(CollectionDescriptor annotation, ProviderFactory providerFactory, GenerationRule generationRule, ConversionAdapter conversionAdapter,Class<?> clazz) {
        super(annotation, providerFactory);
        min = annotation.min();
        max = annotation.max();
        this.mGenerationRule = generationRule;
        this.mConversionAdapter = conversionAdapter;
        mClazz = clazz;
    }

    @Override
    public Object generate() {
        int random = min + (getRandom().nextInt(max - min)) + 1;
        Object array = Array.newInstance(mClazz, random);
        for (int i = 0; i < random; i++) {
            Array.set(array,i,mConversionAdapter.value(mGenerationRule.generate()));
        }
        return array;
    }
}
