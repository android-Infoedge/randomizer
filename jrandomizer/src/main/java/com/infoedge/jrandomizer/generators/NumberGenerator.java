package com.infoedge.jrandomizer.generators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.infoedge.jrandomizer.annotations.Number;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 28/7/16.
 */

public class NumberGenerator extends GenerationRule<Number, Double> {

    private long min;
    private long max;
    private int decimalPlaces;

    public NumberGenerator(Number annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public Double generate() {
        Number annotation = getAnnotation();
        min = annotation.min();
        max = annotation.max();
        decimalPlaces = annotation.decimals();
        double number = (min + (Math.random() * ((max - min) + 1)));
        if (decimalPlaces > 0) {
            number = round(number, decimalPlaces);
        }
        return number;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
