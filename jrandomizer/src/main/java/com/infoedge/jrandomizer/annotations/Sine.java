package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.DoubleListToDoubleList;
import com.infoedge.jrandomizer.adapters.DoubleListToFloatList;
import com.infoedge.jrandomizer.fieldtype.DoubleList;
import com.infoedge.jrandomizer.fieldtype.FloatList;
import com.infoedge.jrandomizer.generators.SineGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ronakporiya on 22/10/16.
 */
@GenerateUsing(generator = SineGenerator.class, mapping = {
        @Mapping(fieldType = DoubleList.class, adapter = DoubleListToDoubleList.class),
        @Mapping(fieldType = FloatList.class, adapter = DoubleListToFloatList.class),
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Sine {
    double amplitude() default 1;

    double from() default 0;

    double to() default 90;

    double stepSize() default 1;
}