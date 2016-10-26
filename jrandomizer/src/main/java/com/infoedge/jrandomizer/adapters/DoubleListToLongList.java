package com.infoedge.jrandomizer.adapters;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToLongList implements ConversionAdapter<List<Double>,List<Long>> {

    @Override
    public List<Long> value(List<Double> randomData) {
        return randomData.stream().map(Double::longValue).collect(Collectors.toList());
    }
}
