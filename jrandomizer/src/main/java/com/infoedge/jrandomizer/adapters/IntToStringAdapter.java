package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class IntToStringAdapter implements ConversionAdapter<Integer,String> {

    @Override
    public String value(Integer randomData) {
        return String.valueOf(randomData);
    }
}
