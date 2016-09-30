package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class TopLevelDomainProvider extends Provider<String[]> {

    private TopLevelDomainProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[] {"aero",
                    "asia",
                    "biz",
                    "cat",
                    "com",
                    "coop",
                    "edu",
                    "gov",
                    "info",
                    "int",
                    "jobs",
                    "mil",
                    "mobi",
                    "museum",
                    "name",
                    "net",
                    "org",
                    "pro",
                    "tel",
                    "travel",
                    "xxx"};
        }
        return mLoadedData;
    }

}
