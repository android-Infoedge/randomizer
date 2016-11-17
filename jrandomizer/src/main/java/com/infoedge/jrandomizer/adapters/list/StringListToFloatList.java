package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToFloatList implements ConversionAdapter<List<String>,List<Float>>{
    @Override
    public List<Float> value(List<String> randomData) {
        List<Float> floatList = new ArrayList<>();
        for (String string : randomData) {
            floatList.add(Float.valueOf(string));
        }
        return floatList;
    }
}
