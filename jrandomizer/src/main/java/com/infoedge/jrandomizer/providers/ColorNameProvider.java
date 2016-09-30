package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class ColorNameProvider extends Provider<String[]> {

    private ColorNameProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "Orange",
                    "Fuscia",
                    "Teal",
                    "Khaki",
                    "Mauv",
                    "Green",
                    "Puce",
                    "Turquoise",
                    "Maroon",
                    "Aquamarine",
                    "Blue",
                    "Purple",
                    "Pink",
                    "Red",
                    "Indigo",
                    "Violet",
                    "Goldenrod",
                    "Crimson",
                    "Yellow"
            };
        }
        return mLoadedData;
    }
}
