package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class LongToLongAdapter implements ConversionAdapter<Long,Long> {
    @Override
    public Long value(Long randomData) {
        return randomData;
    }
}
