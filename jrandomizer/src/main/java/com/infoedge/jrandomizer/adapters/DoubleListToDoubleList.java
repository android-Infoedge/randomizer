package com.infoedge.jrandomizer.adapters;

import java.util.List;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToDoubleList  implements ConversionAdapter<List<Double>,List<Double>> {
    @Override
    public List<Double> value(List<Double> randomData) {
        return randomData;
    }
}
