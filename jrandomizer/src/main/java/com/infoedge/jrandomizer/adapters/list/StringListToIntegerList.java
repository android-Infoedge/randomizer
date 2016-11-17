package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToIntegerList implements ConversionAdapter<List<String>,List<Integer>>{
    @Override
    public List<Integer> value(List<String> randomData) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : randomData) {
            integerList.add(Integer.valueOf(string));
        }
        return integerList;
    }
}
