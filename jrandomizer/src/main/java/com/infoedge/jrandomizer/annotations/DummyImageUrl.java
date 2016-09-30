package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.DummyImageUrlGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = DummyImageUrlGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DummyImageUrl {

    Format format() default Format.RANDOM;

    int width() default 100;
    int height() default 100;

    public enum Format {
        PNG("png"),JPG("jpg"),GIF("gif"),RANDOM("random");

        private String label;
        Format(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
