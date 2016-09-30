package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.FirstNameGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = FirstNameGenerator.class,mapping = {
        @Mapping(fieldType = String.class,adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FirstName {

    Gender gender() default Gender.MIX;

    public enum Gender {
        MALE,FEMALE,MIX
    }
}
