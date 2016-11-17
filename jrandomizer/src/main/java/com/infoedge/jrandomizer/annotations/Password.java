package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.PasswordGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ronakporiya on 22/10/16.
 */

@GenerateUsing(generator = PasswordGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {

    int minLength() default 6;

    int maxLength() default 12;

    PasswordType type() default PasswordType.ALPHA;

    enum PasswordType {
        ALPHA(PasswordGenerator.ALPHA),ALPHA_NUMERIC(PasswordGenerator.ALPHA_NUMERIC),ALPHA_SPECIAL_CHAR(PasswordGenerator.ALPHA_SPECIAL_CHAR),ALPHA_NUMERIC_SPECIAL_CHAR(PasswordGenerator.ALPHA_NUMERIC_SPECIAL_CHAR);

        private int passwordType;

        PasswordType(int type) {
            this.passwordType = type;
        }

        public int getPasswordType() {
            return passwordType;
        }
    }


}
