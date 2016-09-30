package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.DateValueGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = DateValueGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DateValue {
    String from() default "";

    String to() default "";

    Format format() default Format.MMlddlyyyy;

    String customFormat() default "";

    public enum Format {
        MMlddlyyyy("MM/dd/yyyy"), Mlldlyyyy("M/d/yyyy"), yyyy_MM_dd("yyyy-MM-dd"), dlMlyyyy("d/M/yyyy"), ddlMMlyyyy("dd/MM/yyyy");


        private String value;

        Format(String format) {
            this.value = format;
        }

        public String getValue() {
            return value;
        }
    }
}
