package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class TitleProvider extends Provider<String[]> {
    private TitleProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "Mrs",
                    "Ms",
                    "Dr",
                    "Mr",
                    "Rev",
                    "Honorable"
            };
        }
        return mLoadedData;
    }
}
