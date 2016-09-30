package com.infoedge.jrandomizer.providers;

import com.google.gson.Gson;

/**
 * Created by gagandeep on 30/7/16.
 */

public abstract class FromJsonProvider<DATA_TYPE> extends Provider<DATA_TYPE> {

    public FromJsonProvider(Class<DATA_TYPE> clazz) {
        super(clazz);
    }

    protected abstract String json();

    public DATA_TYPE provide() {
        if (mLoadedData == null) {
            mLoadedData = new Gson().fromJson(json(), getDataClass());
        }
        return mLoadedData;
    }
}
