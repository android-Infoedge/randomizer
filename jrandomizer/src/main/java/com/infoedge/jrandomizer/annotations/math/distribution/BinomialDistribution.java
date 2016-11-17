package com.infoedge.jrandomizer.annotations.math.distribution;

import com.infoedge.jrandomizer.adapters.list.StringListToBooleanList;
import com.infoedge.jrandomizer.adapters.list.StringListToDoubleList;
import com.infoedge.jrandomizer.adapters.list.StringListToFloatList;
import com.infoedge.jrandomizer.adapters.list.StringListToIntegerList;
import com.infoedge.jrandomizer.adapters.list.StringListToLongList;
import com.infoedge.jrandomizer.adapters.list.StringListToStirngList;
import com.infoedge.jrandomizer.annotations.GenerateUsing;
import com.infoedge.jrandomizer.annotations.Mapping;
import com.infoedge.jrandomizer.fieldtype.BooleanList;
import com.infoedge.jrandomizer.fieldtype.DoubleList;
import com.infoedge.jrandomizer.fieldtype.FloatList;
import com.infoedge.jrandomizer.fieldtype.IntegerList;
import com.infoedge.jrandomizer.fieldtype.LongList;
import com.infoedge.jrandomizer.fieldtype.StringList;
import com.infoedge.jrandomizer.generators.BinomialDistributionGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ronakporiya on 27/10/16.
 */
@GenerateUsing(generator = BinomialDistributionGenerator.class, mapping = {
        @Mapping(fieldType = StringList.class, adapter = StringListToStirngList.class),
        @Mapping(fieldType = BooleanList.class, adapter = StringListToBooleanList.class),
        @Mapping(fieldType = IntegerList.class, adapter = StringListToIntegerList.class),
        @Mapping(fieldType = FloatList.class, adapter = StringListToFloatList.class),
        @Mapping(fieldType = DoubleList.class, adapter = StringListToDoubleList.class),
        @Mapping(fieldType = LongList.class, adapter = StringListToLongList.class),
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BinomialDistribution {

    double probability();

    int listSize();

    String trueValue() default "1";

    String falseValue() default "0";

}
