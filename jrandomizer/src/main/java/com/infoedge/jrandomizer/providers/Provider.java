package com.infoedge.jrandomizer.providers;

import java.util.Random;

/**
 * Created by gagandeep on 30/7/16.
 */

public abstract class Provider<DATA_TYPE> {

    private Class<DATA_TYPE> clazz;
    protected DATA_TYPE mLoadedData;

    public Provider(Class<DATA_TYPE> clazz) {
        this.clazz = clazz;
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass().getSimpleName().equals(obj.getClass().getSimpleName())) {
            return true;
        }
        return false;
    }

    public abstract DATA_TYPE provide();

    Class<DATA_TYPE> getDataClass() {
        return clazz;
    }
}
