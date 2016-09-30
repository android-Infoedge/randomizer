package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 30/7/16.
 */

public class ObjectToObjectAdapter implements ConversionAdapter<Object,Object> {
    @Override
    public Object value(Object randomData) {
        return randomData;
    }
}
