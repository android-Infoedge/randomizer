package com.infoedge.jrandomizer;


import com.infoedge.jrandomizer.adapters.ConversionAdapter;
import com.infoedge.jrandomizer.adapters.ObjectToObjectAdapter;
import com.infoedge.jrandomizer.annotations.CollectionDescriptor;
import com.infoedge.jrandomizer.annotations.CustomGenerator;
import com.infoedge.jrandomizer.generators.GenerationRule;
import com.infoedge.jrandomizer.generators.RandomListGenerator;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gagandeep on 28/7/16.
 */

public final class Generator<TARGET> {

    private Class<TARGET> mTarget;
    private Map<Field, Pair<GenerationRule, ConversionAdapter>> mFieldRuleMapping = new HashMap<>();

    public Generator(Class<TARGET> target) {
        this.mTarget = target;
    }

    public TARGET generate() {
        return generate(1).get(0);
    }

    public void generateAsync(OnDataGenerationListener<TARGET> listener) {
        generateAsync(1, listener);
    }

    public void generateAsync(int records, OnDataGenerationListener<TARGET> listener) {
        DataGenerationRunnable<TARGET> targetDataGenerationRunnable = new DataGenerationRunnable<>(listener, records);
        new Thread(targetDataGenerationRunnable).start();
    }

    public List<TARGET> generate(int records) {
        List<Field> targetAnnotatedFields = Reflector.getValidTargetAnnotatedFields(mTarget);
        createGenerationRules(targetAnnotatedFields);
        List<TARGET> randomData = new ArrayList<>(records);
        for (int i = 0; i < records; i++) {
            TARGET instance = (TARGET) Reflector.createInstance(mTarget);
            Set<Field> fields = mFieldRuleMapping.keySet();
            for (Field field : fields) {
                Pair<GenerationRule, ConversionAdapter> pair = mFieldRuleMapping.get(field);
                GenerationRule generationRule = pair.first;
                ConversionAdapter conversionAdapter = pair.second;
                try {
                    field.setAccessible(true);
                    field.set(instance, conversionAdapter.value(generationRule.generate()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            randomData.add(instance);
        }
        return randomData;
    }


    private Map<Field, Pair<GenerationRule, ConversionAdapter>> createGenerationRules(List<Field> targetAnnotatedFields) {
        Map<Field, Pair<GenerationRule, ConversionAdapter>> generationRules = new LinkedHashMap<>();
        for (Field targetAnnotatedField : targetAnnotatedFields) {
            Annotation[] annotations = targetAnnotatedField.getAnnotations();
            for (Annotation annotation : annotations) {
                if (Reflector.isValidTargetAnnotatedField(annotation.annotationType())) {
                    mFieldRuleMapping.put(targetAnnotatedField, getGenerationRulePair(targetAnnotatedField, annotation));
                }
            }
        }
        return generationRules;
    }

    private Pair<GenerationRule, ConversionAdapter> getGenerationRulePair(Field targetField, Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Class<? extends ConversionAdapter> conversionAdapterType = Reflector.getConversionAdapterType(targetField, annotationType);
        ConversionAdapter conversionAdapter = Reflector.instantiateConversionAdapter(conversionAdapterType);
        GenerationRule generationRule = null;
        CustomGenerator customGenerator = Reflector.getCustomGeneratorAnnotation(targetField);
        if (customGenerator != null) {
            generationRule = Reflector.getCustomGenerator(customGenerator, annotation);
        } else {
            Class<? extends GenerationRule> generatorType = Reflector.getGeneratorType(annotation);
            generationRule = Reflector.instantiateGenerationRule(generatorType, annotation);
        }
        if (Reflector.getIfCollectionField(targetField) != null) {
            generationRule = Reflector.instantiateCollectionGenerationRule(targetField, generationRule, conversionAdapter);
            conversionAdapter = (ConversionAdapter) Reflector.createInstance(ObjectToObjectAdapter.class);
        }
        return new Pair<>(generationRule, conversionAdapter);
    }


    public interface OnDataGenerationListener<TARGET> {
        void onDataGenerated(List<TARGET> randomData);
    }

    private class DataGenerationRunnable<TARGET> implements Runnable {

        private OnDataGenerationListener<TARGET> mListener;
        private int records;

        public DataGenerationRunnable(OnDataGenerationListener<TARGET> mListener, int records) {
            this.mListener = mListener;
            this.records = records;
        }

        @Override
        public void run() {
            List<TARGET> randomData = (List<TARGET>) generate(records);
            if (mListener != null) {
                mListener.onDataGenerated(randomData);
            }
        }
    }

}
