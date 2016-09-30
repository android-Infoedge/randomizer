package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Sequence;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class SequenceGenerator extends GenerationRule<Sequence,Integer> {

    int startAt;
    int step;
    int repeat;
    int restartAt;

    int repeatCounter;
    int nextSequence;

    public SequenceGenerator(Sequence annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        startAt = annotation.startAt();
        step = annotation.step();
        repeat = annotation.repeat();
        restartAt = annotation.restartAt();

        if (repeat < 1) {
            repeat = 1;
        }

        if (step < 1) {
            step = 1;
        }

        repeatCounter = repeat;
        nextSequence = startAt;
    }

    @Override
    public Integer generate() {
        if (nextSequence > restartAt) {
            nextSequence = startAt;
        }

        if (repeatCounter > 1) {
            repeatCounter--;
            return nextSequence;
        }

        repeatCounter = repeat;
        int lastSequence = nextSequence;
        nextSequence = nextSequence + step;
        return lastSequence;
    }
}
