package com.infoedge.jrandomizer.adapters.list;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 27/10/16.
 */
public class StringListToBooleanList implements ConversionAdapter<List<String>, List<Boolean>> {
    @Override
    public List<Boolean> value(List<String> randomData) {
        List<Boolean> booleanList = new ArrayList<>();
        for (String string : randomData) {
            booleanList.add(valueOf(string));
        }
        return booleanList;
    }

    public Boolean valueOf(String string) {
        if (!string.equalsIgnoreCase("true") || (!string.equals("false"))) {
            throw new IllegalArgumentException("For input string : " + string);
        }
        return Boolean.valueOf(string);
    }
}
