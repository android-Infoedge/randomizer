package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.BooleanToBooleanAdapter;
import com.infoedge.jrandomizer.generators.BooleanGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = BooleanGenerator.class,mapping = {
        @Mapping(fieldType = Boolean.class, adapter = BooleanToBooleanAdapter.class),
        @Mapping(fieldType = boolean.class, adapter = BooleanToBooleanAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BooleanValue {

}
