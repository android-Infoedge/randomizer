package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class SuffixProvider extends Provider<String[]> {
    private SuffixProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "Jr",
                    "II",
                    "IV",
                    "III",
                    "Sr"
            };
        }
        return mLoadedData;
    }
}
