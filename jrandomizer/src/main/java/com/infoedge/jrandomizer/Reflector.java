package com.infoedge.jrandomizer;

import com.infoedge.jrandomizer.adapters.ConversionAdapter;
import com.infoedge.jrandomizer.annotations.CollectionDescriptor;
import com.infoedge.jrandomizer.annotations.CustomGenerator;
import com.infoedge.jrandomizer.annotations.GenerateUsing;
import com.infoedge.jrandomizer.annotations.Mapping;
import com.infoedge.jrandomizer.annotations.ReferenceRecord;
import com.infoedge.jrandomizer.annotations.ReferencedRecord;
import com.infoedge.jrandomizer.exceptions.RandomDataGeneratorException;
import com.infoedge.jrandomizer.fieldtype.BooleanList;
import com.infoedge.jrandomizer.fieldtype.DoubleList;
import com.infoedge.jrandomizer.fieldtype.FloatList;
import com.infoedge.jrandomizer.fieldtype.IntegerList;
import com.infoedge.jrandomizer.fieldtype.LongList;
import com.infoedge.jrandomizer.fieldtype.StringList;
import com.infoedge.jrandomizer.generators.DelegateGenerationRule;
import com.infoedge.jrandomizer.generators.GenerationRule;
import com.infoedge.jrandomizer.generators.InvalidGenerator;
import com.infoedge.jrandomizer.generators.RandomArrayGenerator;
import com.infoedge.jrandomizer.generators.RandomListGenerator;
import com.infoedge.jrandomizer.generators.ReferenceRecordGenerator;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by gagandeep on 28/7/16.
 */

class Reflector {

    public static final List<Class> fieldTypeList = Arrays.asList(StringList.class,BooleanList.class,IntegerList.class, DoubleList.class, FloatList.class, LongList.class);

    static List<Field> getValidTargetAnnotatedFields(Class<?> clazz) {
        List<Field> targetFields = new ArrayList<>();
        List<Field> allTargetFields = getAllTargetFields(clazz);
        for (Field field : allTargetFields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (isValidTargetAnnotatedField(annotation.annotationType())) {
                    targetFields.add(field);
                    break;
                }
            }
        }
        return targetFields;
    }

    private static List<Field> getAllTargetFields(final Class<?> controllerClass) {
        List<Field> allFields = new ArrayList<Field>();

        // Fields declared in the controller
        allFields.addAll(getFields(controllerClass));

        // Inherited fields
        Class<?> superClass = controllerClass.getSuperclass();
        while (!superClass.equals(Object.class)) {
            List<Field> viewFields = getFields(superClass);
            if (viewFields.size() > 0) {
                allFields.addAll(viewFields);
            }
            superClass = superClass.getSuperclass();
        }

        return allFields;
    }

    private static List<Field> getFields(final Class<?> clazz) {
        List<Field> viewFields = new ArrayList<Field>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            viewFields.add(field);
        }
        return viewFields;
    }

    static Object createInstance(Class<?> clazz) {
        Object target = null;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }

    private static GenerateUsing getGenerateUsingAnnotation(Class<? extends Annotation> annotationType) {
        GenerateUsing generateUsing = null;
        Annotation[] declaredAnnotations = annotationType.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            if (GenerateUsing.class.equals(annotation.annotationType())) {
                generateUsing = (GenerateUsing) annotation;
                break;
            }
        }
        return generateUsing;
    }

    static Class<? extends GenerationRule> getGeneratorType(Annotation annotation) {
        GenerateUsing generateUsing = getGenerateUsingAnnotation(annotation.annotationType());
        return generateUsing.generator();
    }

    static Class<? extends ConversionAdapter> getConversionAdapterType(Field targetField, Class<? extends Annotation> ruleAnnotation) {
        Class<?> targetFieldType = targetField.getType();
        if (ruleAnnotation == ReferenceRecord.class && targetField.getAnnotation(CustomGenerator.class) != null) {
            String message = String.format("%s and %s can not be set on field %s simultaneously", ReferenceRecord.class.getSimpleName(),CustomGenerator.class.getSimpleName(),targetField.getName());
            throw new RandomDataGeneratorException(message);
        }
        if (ruleAnnotation == ReferenceRecord.class) {
            if (Collection.class.isAssignableFrom(targetFieldType)) {
                ParameterizedType listType = (ParameterizedType) targetField.getGenericType();
                targetFieldType = (Class<?>) listType.getActualTypeArguments()[0];
                if (targetFieldType.getAnnotation(ReferencedRecord.class) == null) {
                    String message = String.format("Field %s with annotation %s of type %s must have annotation of %s", targetField.getName(), ReferenceRecord.class.getSimpleName()
                            , targetFieldType.getSimpleName(), ReferencedRecord.class.getSimpleName());
                    throw new RandomDataGeneratorException(message);
                }
            } else {
                if (targetFieldType.getAnnotation(ReferencedRecord.class) == null) {
                    String message = String.format("Field %s with annotation %s of type %s must have annotation of %s", targetField.getName(), ReferenceRecord.class.getSimpleName()
                            , targetFieldType.getSimpleName(), ReferencedRecord.class.getSimpleName());
                    throw new RandomDataGeneratorException(message);
                }
            }
            targetFieldType = ReferenceRecord.class;
        } else if (Collection.class.isAssignableFrom(targetFieldType)) {
            ParameterizedType listType = (ParameterizedType) targetField.getGenericType();
            Class<?> mappingFieldList = checkIfMappingFieldTypeList(targetField,ruleAnnotation);
            if (mappingFieldList != null) {
                targetFieldType = mappingFieldList;
            }else{
                targetFieldType = (Class<?>) listType.getActualTypeArguments()[0];
                if (targetField.getAnnotation(ReferencedRecord.class) != null) {
                    targetFieldType = ReferenceRecord.class;
                }
            }
        } else if (targetFieldType.isArray()) {
            Class<?> componentType = targetFieldType.getComponentType();
            targetFieldType = componentType;
            if (targetField.getAnnotation(ReferencedRecord.class) != null) {
                targetFieldType = ReferenceRecord.class;
            }
        }

        GenerateUsing generateUsing = getGenerateUsingAnnotation(ruleAnnotation);
        Mapping[] mapping = generateUsing.mapping();
        for (Mapping pair : mapping) {
            if (targetFieldType == pair.fieldType()) {
                return pair.adapter();
            }
        }
        String message = String.format("Annotation %s not allowed for field %s", ruleAnnotation.getSimpleName(), targetField.getName());
        throw new RuntimeException(message);
    }

    static boolean isValidTargetAnnotatedField(Class<? extends Annotation> annotationType) {
        GenerateUsing annotation = annotationType.getAnnotation(GenerateUsing.class);
        return annotation != null;
    }

    static boolean isCustomGeneratorAnnotatedField(Class<? extends Annotation> annotationType) {
        CustomGenerator annotation = annotationType.getAnnotation(CustomGenerator.class);
        return annotation != null;
    }

    static CustomGenerator getCustomGeneratorAnnotation(Field targetField) {
        CustomGenerator annotation = targetField.getAnnotation(CustomGenerator.class);
        return annotation;
    }

    static CollectionDescriptor getRandomCollectionAnnotation(Field targetField) {
        CollectionDescriptor annotation = targetField.getAnnotation(CollectionDescriptor.class);
        return annotation;
    }

    static GenerationRule getCustomGenerator(CustomGenerator customGeneratorAnnotation, Annotation randomDataTypeAnnotation) {
        Class<? extends GenerationRule> generator = customGeneratorAnnotation.generator();
        Class<? extends GenerationRule> delegate = customGeneratorAnnotation.delegate();

        if (DelegateGenerationRule.class.isAssignableFrom(generator)) {
            if (delegate != InvalidGenerator.class) {
                return instantiateDelegateGenerationRule(generator, randomDataTypeAnnotation, delegate);
            } else {
                String message = String.format("%s can not work with delegate %s to generate data or %s should not extend %s without specifying valid delegate in annotation", generator.getSimpleName(), delegate.getSimpleName(), generator.getSimpleName(), DelegateGenerationRule.class.getSimpleName());
                throw new RandomDataGeneratorException(message);
            }
        } else {
            return instantiateGenerationRule(generator, randomDataTypeAnnotation);
        }
    }

    static GenerationRule instantiateDelegateGenerationRule(Class<? extends GenerationRule> generatorType, Annotation annotation, Class<? extends GenerationRule> delegateGenerator) {
        GenerationRule generationRule = null;
        if (GenerationRule.class.isAssignableFrom(generatorType)) {
            try {
                Constructor<?> constructor = generatorType.getDeclaredConstructor(annotation.annotationType(), ProviderFactory.class, GenerationRule.class);
                constructor.setAccessible(true);
                generationRule = (GenerationRule) constructor.newInstance(annotation, ProviderFactory.getInstance(), instantiateGenerationRule(delegateGenerator, annotation));
            } catch (NoSuchMethodException e) {
                String message = getMissingConstructorErrorMessage(generatorType,
                        annotation.annotationType());
                throw new RuntimeException(message);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return generationRule;
    }

    static GenerationRule instantiateGenerationRule(Class<? extends GenerationRule> generatorType, Annotation annotation) {
        GenerationRule generationRule = null;
        if (GenerationRule.class.isAssignableFrom(generatorType)) {
            try {
                Constructor<?> constructor = generatorType.getDeclaredConstructor(annotation.annotationType(), ProviderFactory.class);
                constructor.setAccessible(true);
                generationRule = (GenerationRule) constructor.newInstance(annotation, ProviderFactory.getInstance());
            } catch (NoSuchMethodException e) {
                String message = getMissingConstructorErrorMessage(generatorType,
                        annotation.annotationType());
                throw new RuntimeException(message);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return generationRule;
    }

    public static boolean isReferencedFieldType(Field targetField) {
        if (Collection.class.isAssignableFrom(targetField.getType())) {
            ParameterizedType listType = (ParameterizedType) targetField.getGenericType();
            Class<?> type = (Class<?>) listType.getActualTypeArguments()[0];
            if (type.getAnnotation(ReferencedRecord.class) != null) {
                return true;
            }
        }
        return false;
    }

    static GenerationRule instantiateCollectionGenerationRule(Field targetField, GenerationRule generationRule, ConversionAdapter conversionAdapter) {
        if (isReferencedFieldType(targetField)) {
            generationRule = new ReferenceRecordGenerator((ReferenceRecord) generationRule.getAnnotation(), ProviderFactory.getInstance());
        }

        if (checkIfMappingFieldTypeList(targetField,generationRule.getAnnotation().annotationType()) != null) {
            return generationRule;
        }
        CollectionDescriptor collectionDescriptorAnnotation = getRandomCollectionAnnotation(targetField);
        GenerationRule collectionGenerationRule = null;
        if (List.class.isAssignableFrom(targetField.getType())) {
            collectionGenerationRule = new RandomListGenerator(collectionDescriptorAnnotation, ProviderFactory.getInstance(), generationRule, conversionAdapter);
        } else if (targetField.getType().isArray()) {
            collectionGenerationRule = new RandomArrayGenerator(collectionDescriptorAnnotation, ProviderFactory.getInstance(), generationRule, conversionAdapter, targetField.getType().getComponentType());
        }
        return collectionGenerationRule;
    }

    static ConversionAdapter instantiateConversionAdapter(Class<? extends ConversionAdapter> adapter) {
        ConversionAdapter conversionAdapter = null;
        if (ConversionAdapter.class.isAssignableFrom(adapter)) {
            try {
                conversionAdapter = adapter.newInstance();
            } catch (InstantiationException e) {
                String message = String.format("%s must have default constructor", adapter.getSimpleName());
                throw new RuntimeException(message);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return conversionAdapter;
    }

    private static String getMissingConstructorErrorMessage(
            final Class<? extends GenerationRule> ruleType,
            final Class<? extends Annotation> annotationType) {

        String message = null;
        if (GenerationRule.class.isAssignableFrom(ruleType)) {
            message = String.format(
                    "'%s' has invalid number of arguments accepting constructor that accepts a '%s' instance.",
                    ruleType.getName(), annotationType.getName());
        }

        return message;
    }

    public static Class<?> getIfCollectionField(Field field) {
        Class<?> type = field.getType();
        if (Collection.class.isAssignableFrom(type)) {
            return type;
        } else if (field.getType().isArray()) {
            return field.getType().getComponentType();
        }
        return null;
    }

    private static Class<?> checkIfMappingFieldTypeList(Field targetField, Class<? extends Annotation> ruleAnnotation) {
        GenerateUsing generateUsing = getGenerateUsingAnnotation(ruleAnnotation);
        Mapping[] mapping = generateUsing.mapping();
        for (Mapping pair : mapping) {
            if (fieldTypeList.contains(pair.fieldType())) {
                ParameterizedType listType = (ParameterizedType) targetField.getGenericType();
                Class collectionTypeArgument = (Class<?>) listType.getActualTypeArguments()[0];
                ParameterizedType fieldTypeListSuperClass = (ParameterizedType) pair.fieldType().getGenericInterfaces()[0];
                Class fieldTypeArgument = (Class<?>) fieldTypeListSuperClass.getActualTypeArguments()[0];
                if(collectionTypeArgument.equals(fieldTypeArgument)){
                    return pair.fieldType();
                }
            }
        }
        return null;
    }

    private Reflector() {
    }
}