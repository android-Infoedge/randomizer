package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

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
