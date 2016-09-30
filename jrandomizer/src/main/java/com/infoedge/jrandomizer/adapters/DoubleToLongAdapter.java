package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class DoubleToLongAdapter implements ConversionAdapter<Double,Long> {
    @Override
    public Long value(Double randomData) {
        return randomData.longValue();
    }
}
