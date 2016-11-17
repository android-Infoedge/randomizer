package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CarBrand;
import com.infoedge.jrandomizer.providers.CarBrandProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by ronakporiya on 21/10/16.
 */
public class CarBrandGenerator extends GenerationRule<CarBrand,String> {

    private CarBrandProvider mProvider;

    public CarBrandGenerator(CarBrand annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(CarBrandProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] carBrands = mProvider.provide();
        int randomIndex = getRandom().nextInt(carBrands.length);
        return carBrands[randomIndex];
    }
}
