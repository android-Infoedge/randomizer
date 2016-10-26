package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.DoubleToDoubleAdapter;
import com.infoedge.jrandomizer.generators.CosineGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ronakporiya on 22/10/16.
 */
@GenerateUsing(generator = CosineGenerator.class, mapping = {
        @Mapping(fieldType = double.class, adapter = DoubleToDoubleAdapter.class),
        @Mapping(fieldType = Double.class, adapter = DoubleToDoubleAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Cosine {
    double amplitude() default 1;

    double from() default 0;

    double to() default 90;

    double stepSize() default 1;
}