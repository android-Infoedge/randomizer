package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;
import com.infoedge.jrandomizer.annotations.CollectionDescriptor;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gagandeep on 2/8/16.
 */

public class RandomListGenerator extends GenerationRule<CollectionDescriptor, List<Object>> {

    private int min = 1;
    private int max = min;
    private ConversionAdapter mConversionAdapter;
    private GenerationRule mGenerationRule;

    public RandomListGenerator(CollectionDescriptor annotation, ProviderFactory providerFactory, GenerationRule generationRule, ConversionAdapter conversionAdapter) {
        super(annotation, providerFactory);
        if (annotation != null) {
            min = annotation.min();
            max = annotation.max();
        }
        this.mGenerationRule = generationRule;
        this.mConversionAdapter = conversionAdapter;

    }

    @Override
    public List<Object> generate() {
        int random = min + (getRandom().nextInt(max - min + 1)) + 1;
        List<Object> randomList = new ArrayList<>(random);
        for (int i = 0; i < random; i++) {
            randomList.add(mConversionAdapter.value(mGenerationRule.generate()));
        }
        return randomList;
    }
}
