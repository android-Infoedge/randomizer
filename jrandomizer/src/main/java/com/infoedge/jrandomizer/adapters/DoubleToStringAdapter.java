package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public class DoubleToStringAdapter implements ConversionAdapter<Double,String> {
    @Override
    public String value(Double randomData) {
        return randomData.toString();
    }
}
