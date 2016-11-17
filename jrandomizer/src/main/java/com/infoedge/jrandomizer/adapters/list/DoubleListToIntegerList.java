package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToIntegerList implements ConversionAdapter<List<Double>,List<Integer>> {

    @Override
    public List<Integer> value(List<Double> randomData) {
        List<Integer> integerList = new ArrayList<>();
        for (Double doubleValue : randomData) {
            integerList.add(doubleValue.intValue());
        }
        return integerList;
    }
}
