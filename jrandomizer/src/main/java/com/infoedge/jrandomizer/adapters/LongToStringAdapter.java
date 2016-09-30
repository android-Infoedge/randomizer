package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class LongToStringAdapter implements ConversionAdapter<Long,String>{
    @Override
    public String value(Long randomData) {
        return randomData.toString();
    }
}
