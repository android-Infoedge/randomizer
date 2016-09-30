package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class DoubleToFloatAdapter implements ConversionAdapter<Double,Float> {
    @Override
    public Float value(Double randomData) {
        return randomData.floatValue();
    }
}
