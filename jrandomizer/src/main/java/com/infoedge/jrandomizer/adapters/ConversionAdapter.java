package com.infoedge.jrandomizer.adapters;

/**
 * Created by gagandeep on 28/7/16.
 */

public interface ConversionAdapter<FROM_DATA_TYPE,TO_DATA_TYPE> {

    TO_DATA_TYPE value(FROM_DATA_TYPE randomData);
}
