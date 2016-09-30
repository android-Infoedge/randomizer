package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class LongToIntAdapter implements ConversionAdapter<Long,Integer> {
    @Override
    public Integer value(Long randomData) {
        return randomData.intValue();
    }
}
