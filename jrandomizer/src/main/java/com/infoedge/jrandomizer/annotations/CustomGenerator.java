package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.generators.InvalidGenerator;
import com.infoedge.jrandomizer.generators.GenerationRule;

/**
 * Created by gagandeep on 1/8/16.
 */

public @interface CustomGenerator {

    Class<? extends GenerationRule> generator();

    Class<? extends GenerationRule> delegate() default InvalidGenerator.class;
}
