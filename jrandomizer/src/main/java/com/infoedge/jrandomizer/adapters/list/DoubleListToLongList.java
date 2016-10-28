package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 24/10/16.
 */
public class DoubleListToLongList implements ConversionAdapter<List<Double>,List<Long>> {

    @Override
    public List<Long> value(List<Double> randomData) {
        List<Long> longList = new ArrayList<>();
        for (Double doubleValue : randomData) {
            longList.add(doubleValue.longValue());
        }
        return longList;
    }
}
