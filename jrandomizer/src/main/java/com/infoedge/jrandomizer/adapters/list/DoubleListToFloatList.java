package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToFloatList implements ConversionAdapter<List<Double>,List<Float>> {

    @Override
    public List<Float> value(List<Double> randomData) {
        List<Float> floatList = new ArrayList<>();
        for (Double doubleValue : randomData) {
            floatList.add(doubleValue.floatValue());
        }
        return floatList;
    }
}
