package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.DoubleToDoubleAdapter;
import com.infoedge.jrandomizer.adapters.DoubleToFloatAdapter;
import com.infoedge.jrandomizer.adapters.DoubleToIntAdapter;
import com.infoedge.jrandomizer.adapters.DoubleToLongAdapter;
import com.infoedge.jrandomizer.adapters.DoubleToStringAdapter;
import com.infoedge.jrandomizer.generators.NumberGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = NumberGenerator.class,mapping = {
        @Mapping(fieldType = Integer.class,adapter = DoubleToIntAdapter.class),
        @Mapping(fieldType = int.class,adapter = DoubleToIntAdapter.class),
        @Mapping(fieldType = Long.class,adapter = DoubleToLongAdapter.class),
        @Mapping(fieldType = Float.class,adapter = DoubleToFloatAdapter.class),
        @Mapping(fieldType = double.class,adapter = DoubleToDoubleAdapter.class),
        @Mapping(fieldType = Double.class,adapter = DoubleToDoubleAdapter.class),
        @Mapping(fieldType = float.class,adapter = DoubleToFloatAdapter.class),
        @Mapping(fieldType = String.class,adapter = DoubleToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Number {
    long min() default 0;

    long max() default Long.MAX_VALUE;

    int decimals() default 0;
}
