package com.infoedge.jrandomizer.annotations;

import com.infoedge.jrandomizer.adapters.StringToStringAdapter;
import com.infoedge.jrandomizer.generators.MoneyGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gagandeep on 28/7/16.
 */
@GenerateUsing(generator = MoneyGenerator.class,mapping = {
        @Mapping(fieldType = String.class, adapter = StringToStringAdapter.class)
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Money {
    double min() default 0.0;

    double max() default 100;

    In in() default In.RANDOM;

    enum In {
        $("$"),€("€"),₹("₹"),RANDOM("random");

        private String currencySymbol;

        In(String currency) {
            this.currencySymbol = currency;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }
    }
}
