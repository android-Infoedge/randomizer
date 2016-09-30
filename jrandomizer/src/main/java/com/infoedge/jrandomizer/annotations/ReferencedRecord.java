package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.ObjectToObjectAdapter;
import com.infoedge.jrandomizer.generators.ReferenceRecordGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 30/7/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReferencedRecord {
}
