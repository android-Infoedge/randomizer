package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.PhoneGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = PhoneGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Phone {

    Phone.Country country() default Country.INDIA;

    boolean withCountryCode() default true;

    boolean unFormatted() default false;

    boolean domestic() default false;

    enum Country {
        INDIA("+91-{1,10}",70),US("+1-{1,3}-{2,3}-{3,4}", 500);

        private String format;
        private int start;

        Country(String format, int start) {
            this.format = format;
            this.start = start;
        }

        public String getFormat() {
            return format;
        }

        public int getStart() {
            return start;
        }
    }

}
