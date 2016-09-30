package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.generators.GenerationRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface GenerateUsing {
    Class<? extends GenerationRule> generator();

    public Mapping[] mapping() default {};
}
