package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.math.distribution.BinomialDistribution;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class BinomialDistributionGenerator extends GenerationRule<BinomialDistribution, List<String>> {

    double probability;
    int listSize;
    String trueValue;
    String falseValue;
    public BinomialDistributionGenerator(BinomialDistribution annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        probability = annotation.probability();
        listSize = annotation.listSize();
        trueValue =  annotation.trueValue();
        falseValue = annotation.falseValue();
    }

    @Override
    public List<String> generate() {

        List<String> distrubutionList = new ArrayList<>();
        String[] stringArray = new String[listSize];
        Arrays.fill(stringArray,falseValue);

        int trueCount = (int) (listSize *probability);
        Arrays.fill(stringArray, 0, trueCount, trueValue);

        distrubutionList.addAll(Arrays.asList(stringArray));
        Collections.shuffle(distrubutionList);

        return distrubutionList;
    }


}