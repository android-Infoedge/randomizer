package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Generator;
import com.infoedge.jrandomizer.annotations.ReferenceRecord;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class ReferenceRecordGenerator extends GenerationRule<ReferenceRecord,Object> {

    public ReferenceRecordGenerator(ReferenceRecord annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public Object generate() {
        Generator generator = new Generator(getAnnotation().clazz());
        return generator.generate();
    }
}
