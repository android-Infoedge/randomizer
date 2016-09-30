package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.ObjectToObjectAdapter;
import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.CityGenerator;
import com.infoedge.jrandomizer.generators.RandomListGenerator;
import com.infoedge.jrandomizer.generators.ReferenceRecordGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CollectionDescriptor {
    int min() default 1;

    int max() default 1;
}
