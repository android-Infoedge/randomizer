package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Cosine;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 21/10/16.
 */
public class CosineGenerator extends GenerationRule<Cosine, List<Double>> {

    private double fromValue;
    private double toValue;
    private double amplitude = 1;
    private double stepSize = 1;
    private List<Double> SineWaveValues;

    public CosineGenerator(Cosine annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        fromValue = annotation.from();
        toValue = annotation.to();
        amplitude = annotation.amplitude();
        amplitude = (amplitude == 0) ? 1 : amplitude;
        stepSize = annotation.stepSize();
        SineWaveValues = new ArrayList<>();
    }

    @Override
    public List<Double> generate() {

        for (double angle = fromValue; angle <= toValue; angle+=stepSize) {
            double radianValue = Math.toRadians(angle);
            SineWaveValues.add(amplitude*Math.cos(radianValue));
        }
        return SineWaveValues;
    }
}
