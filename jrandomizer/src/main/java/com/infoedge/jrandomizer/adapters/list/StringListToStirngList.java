package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToStirngList implements ConversionAdapter<List<String>,List<String>> {
    @Override
    public List<String> value(List<String> randomData) {
        return randomData;
    }
}
