package com.infoedge.jrandomizer.adapters;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToIntegerList implements ConversionAdapter<List<Double>,List<Integer>> {

    @Override
    public List<Integer> value(List<Double> randomData) {
        return randomData.stream().map(Double::intValue).collect(Collectors.toList());
    }
}
