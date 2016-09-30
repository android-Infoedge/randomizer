package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class IntToIntAdapter implements ConversionAdapter<Integer,Integer> {

    @Override
    public Integer value(Integer randomData) {
        return randomData;
    }
}
