package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class ShirtSizeProvider extends Provider<String[]> {
    private ShirtSizeProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[] {
                    "XS",
                    "XL",
                    "M",
                    "2XL",
                    "3XL",
                    "L",
                    "S",
            };
        }
        return mLoadedData;
    }
}
