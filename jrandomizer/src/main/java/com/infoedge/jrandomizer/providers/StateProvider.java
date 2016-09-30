package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class StateProvider extends Provider<String[]> {
    private StateProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[] {
                    "California",
                    "Florida",
                    "Texas",
                    "Virginia",
                    "Ohio",
                    "Nevada",
                    "Wisconsin",
                    "Arizona",
                    "Kansas",
                    "Mississippi",
                    "New Mexico",
                    "Georgia",
                    "Missouri",
                    "District of Columbia",
                    "Oklahoma",
                    "Pennsylvania",
                    "South Carolina",
                    "Alabama",
                    "Colorado",
                    "Massachusetts",
                    "Montana",
                    "Illinois",
                    "North Carolina",
                    "Louisiana",
                    "Oregon",
                    "Alaska",
                    "South Dakota",
                    "Idaho",
                    "Nebraska",
                    "Michigan",
                    "Indiana",
                    "New York",
                    "Connecticut",
                    "Utah",
                    "Maryland",
                    "Tennessee",
                    "New Jersey",
                    "Minnesota",
                    "Arkansas",
                    "Iowa",
                    "Delaware",
                    "North Dakota",
                    "Washington",
                    "Hawaii",
                    "Kentucky",
                    "West Virginia",
                    "New Hampshire",
                    "Rhode Island",
                    "Maine",
                    "Wyoming"
            };
        }
        return mLoadedData;
    }
}
