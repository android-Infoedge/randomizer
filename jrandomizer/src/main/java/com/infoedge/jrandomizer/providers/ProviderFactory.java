package com.infoedge.jrandomizer.providers;

import com.infoedge.jrandomizer.exceptions.RandomDataGeneratorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by gagandeep on 30/7/16.
 */

public class ProviderFactory {

    private WeakHashMap<Provider<?>, Object> mProvidersMap = new WeakHashMap<>();

    private static ProviderFactory mInstance;
    private ProviderFactory() {
    }

    public static ProviderFactory getInstance() {
        if (mInstance == null) {
            mInstance = new ProviderFactory();
        }
        return mInstance;
    }

    public <T extends Provider,D> T provider(Class<T> clazz,Class<D> dataClass) {
        T provider = (T) createInstance(clazz, dataClass);
        if (!mProvidersMap.containsKey(provider)) {
            mProvidersMap.put(provider, new Object());
        } else {
            Set<Provider<?>> providers = mProvidersMap.keySet();
            for (Provider<?> providerKey : providers) {
                if (providerKey.equals(provider)) {
                    provider = null;
                    return (T) providerKey;
                }
            }
        }
        return provider;
    }

    private <T extends Provider,D> Provider<D> createInstance(Class<T> clazz,Class<D> dataClass) {
        Provider<D> target = null;
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(Class.class);
            if (Modifier.isPublic(constructor.getModifiers())) {
                String message = String.format("All Constructors of class %s should be private", clazz.getSimpleName());
                throw new RandomDataGeneratorException(message);
            }
            constructor.setAccessible(true);
            target = (Provider<D>) constructor.newInstance(dataClass);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return target;
    }
}
