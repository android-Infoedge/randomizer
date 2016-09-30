package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.FileNameGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = FileNameGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FileName {

    Types types() default Types.COMMON;

    FileName.Format format() default Format.RANDOM;

    public enum Types {
        ALL,COMMON,CODE,DOCUMENT,IMAGE,MEDIA,TEXT
    }

    public enum Format {
        FileName,fileName,file_name,RANDOM
    }

}
