package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.RowNumber;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class RowNumberGenerator extends GenerationRule<RowNumber,Long>{

    private long mNumber;

    public RowNumberGenerator(RowNumber annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mNumber = annotation.startFrom();
    }

    @Override
    public Long generate() {
        return mNumber++;
    }
}
