package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 29/7/16.
 */

public class BooleanToBooleanAdapter implements ConversionAdapter<Boolean,Boolean> {
    @Override
    public Boolean value(Boolean randomData) {
        return randomData;
    }
}
