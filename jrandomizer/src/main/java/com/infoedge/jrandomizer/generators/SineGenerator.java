package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.math.trigonometry.Sine;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronakporiya on 21/10/16.
 */
public class SineGenerator extends GenerationRule<Sine, List<Double>> {

    private double fromValue;
    private double toValue;
    private double amplitude = 1;
    private double stepSize = 1;
    private List<Double> SineWaveValues;

    public SineGenerator(Sine annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        fromValue = annotation.from();
        toValue = annotation.to();
        amplitude = annotation.amplitude();
        stepSize = annotation.stepSize();
        SineWaveValues = new ArrayList<>();
    }

    @Override
    public List<Double> generate() {

        for (double angle = fromValue; angle <= toValue; angle+=stepSize) {
            double radianValue = Math.toRadians(angle);
            SineWaveValues.add(amplitude*Math.sin(radianValue));
        }
        return SineWaveValues;
    }
}
