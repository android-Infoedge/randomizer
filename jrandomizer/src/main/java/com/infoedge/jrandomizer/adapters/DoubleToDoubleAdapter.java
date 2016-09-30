package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class DoubleToDoubleAdapter implements ConversionAdapter<Double,Double> {
    @Override
    public Double value(Double randomData) {
        return randomData;
    }
}
