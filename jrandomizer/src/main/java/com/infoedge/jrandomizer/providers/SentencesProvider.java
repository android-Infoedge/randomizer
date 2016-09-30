package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SentencesProvider extends Provider<String[]> {

    private SentencesProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{

            };
        }
        return mLoadedData;
    }
}
