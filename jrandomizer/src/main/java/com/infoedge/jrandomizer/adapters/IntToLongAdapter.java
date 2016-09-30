package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class IntToLongAdapter implements ConversionAdapter<Integer,Long> {

    @Override
    public Long value(Integer randomData) {
        return Long.valueOf(randomData);
    }
}
