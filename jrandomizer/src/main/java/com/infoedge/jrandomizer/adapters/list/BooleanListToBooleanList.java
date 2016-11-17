package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class BooleanListToBooleanList implements ConversionAdapter<List<Boolean>,List<Boolean>> {

    @Override
    public List<Boolean> value(List<Boolean> randomData) {
        return randomData;
    }
}
