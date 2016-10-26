package com.infoedge.jrandomizer.adapters;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToFloatList implements ConversionAdapter<List<Double>,List<Float>> {

    @Override
    public List<Float> value(List<Double> randomData) {
        return randomData.stream().map(Double::floatValue).collect(Collectors.toList());
    }
}
