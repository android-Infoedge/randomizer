package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class StringToStringAdapter implements ConversionAdapter<String,String> {

    @Override
    public String value(String randomData) {
        return randomData;
    }
}
