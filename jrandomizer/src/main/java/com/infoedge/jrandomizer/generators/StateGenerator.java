package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.State;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.StateProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class StateGenerator extends GenerationRule<State,String> {
    private StateProvider mProvider;

    public StateGenerator(State annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(StateProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] states = mProvider.provide();
        int randomIndex = getRandom().nextInt(states.length);
        return states[randomIndex];
    }

}
