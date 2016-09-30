package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.CustomList;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class CustomListGenerator extends GenerationRule<CustomList, String> {

    public CustomListGenerator(CustomList annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        String[] options = getAnnotation().options();
        int index = getRandom().nextInt(options.length);
        return options[index];
    }
}
