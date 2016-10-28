package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToLongList implements ConversionAdapter<List<String>,List<Long>>{
    @Override
    public List<Long> value(List<String> randomData) {
        List<Long> longList = new ArrayList<>();
        for (String string : randomData) {
            longList.add(Long.valueOf(string));
        }
        return longList;
    }
}
