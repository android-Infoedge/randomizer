package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToDoubleList implements ConversionAdapter<List<String>,List<Double>>{
    @Override
    public List<Double> value(List<String> randomData) {
        List<Double> doubleList = new ArrayList<>();
        for (String string : randomData) {
            doubleList.add(Double.valueOf(string));
        }
        return doubleList;
    }
}
