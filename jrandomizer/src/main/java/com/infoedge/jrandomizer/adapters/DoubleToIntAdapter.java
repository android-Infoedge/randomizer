package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class DoubleToIntAdapter implements ConversionAdapter<Double,Integer> {
    @Override
    public Integer value(Double randomData) {
        return randomData.intValue();
    }
}
