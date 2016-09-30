package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.LongToIntAdapter;
import com.infoedge.jrandomizer.adapters.LongToLongAdapter;
import com.infoedge.jrandomizer.adapters.LongToStringAdapter;
import com.infoedge.jrandomizer.generators.RowNumberGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = RowNumberGenerator.class,mapping = {
        @Mapping(fieldType = Integer.class, adapter = LongToIntAdapter.class),
        @Mapping(fieldType = int.class, adapter = LongToIntAdapter.class),
        @Mapping(fieldType = Long.class, adapter = LongToLongAdapter.class),
        @Mapping(fieldType = long.class, adapter = LongToLongAdapter.class),
        @Mapping(fieldType = String.class, adapter = LongToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RowNumber {
    long startFrom() default 0;
}
