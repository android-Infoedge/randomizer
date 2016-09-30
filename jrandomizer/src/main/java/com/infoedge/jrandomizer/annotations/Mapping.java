package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Mapping {
    Class<?> fieldType();

    Class<? extends ConversionAdapter<?, ?>> adapter();
}
