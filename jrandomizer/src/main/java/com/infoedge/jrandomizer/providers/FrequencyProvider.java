package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class FrequencyProvider extends Provider<String[]> {

    private FrequencyProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "Often",
                    "Yearly",
                    "Once",
                    "Weekly",
                    "Monthly",
                    "Seldom",
                    "Daily",
                    "Never",
            };
        }
        return mLoadedData;
    }
}
